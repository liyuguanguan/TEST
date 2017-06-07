package com.ygjt.gdn.ftisp.common.resolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.common.ResultData;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yhj on 16/10/29.
 */
public class ControllerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionResolver.class);

    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOG.error(ex.getMessage(),ex);
        Throwable cause = ex.getCause() == null ? ex:ex.getCause();

        if(cause instanceof IllegalArgumentException){
            try {
                IllegalArgumentException illegalArgumentException = (IllegalArgumentException)cause;


                ResultData<?> resultData =  ResultFactory.createFailResultData(illegalArgumentException.getMessage());

                HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);

                converter.write(resultData, MediaType.APPLICATION_JSON,outputMessage);
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
            }
        }else if(cause instanceof NestedServletException ||  cause instanceof SQLException){
            HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);

            try {
                if(cause instanceof MyBatisSystemException){
                    converter.write(ResultFactory.createFailResultData("数据库操作异常!"), MediaType.APPLICATION_JSON,outputMessage);
                }else{
                    converter.write(ResultFactory.createFailResultData("数据库操作异常!"), MediaType.APPLICATION_JSON,outputMessage);
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
            }
        }else if(cause instanceof RuntimeException){

            try {
                ResultData<?> resultData =  ResultFactory.createFailResultData(cause.getMessage());

                HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);

                converter.write(resultData, MediaType.APPLICATION_JSON,outputMessage);
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
            }

        }else{

            HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);

            try {
                converter.write(ResultFactory.createFailResultData("未知异常!"), MediaType.APPLICATION_JSON,outputMessage);
            } catch (IOException e) {
                LOG.error(e.getMessage(),e);
            }

        }

        return new ModelAndView();
    }
}
