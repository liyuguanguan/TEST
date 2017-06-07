package com.ygjt.gdn.ftisp.common.resolver;


import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.utils.ConversionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ValueConstants;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heavenick on 2016/5/17.
 */
public class ParamMethodArgumentResolver extends RequestParamMethodArgumentResolver{

    public ParamMethodArgumentResolver() {
        super(null,true);
    }


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> paramType = parameter.getParameterType();
        if (parameter.hasParameterAnnotation(ParamBind.class)) {
            if (Map.class.isAssignableFrom(paramType)) {
                String paramName = parameter.getParameterAnnotation(ParamBind.class).value();
                return StringUtils.hasText(paramName);
            }
            else {
                return true;
            }
        }
        return false;
    }

    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {

        ParamBind ann = parameter.getParameterAnnotation(ParamBind.class);

        return (ann != null
                ? new RequestParamNamedValueInfo(parameter.getParameterType(),ann)
                : new RequestParamNamedValueInfo(parameter.getParameterType()));
    }

    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {

        Object obj = super.resolveName(name, parameter, request);

        if(obj != null){
            return obj;
        }

        obj = BeanUtils.instantiateClass(parameter.getParameterType());


        ParamDataBinder binder = new ParamDataBinder(obj,name);
        binder.setConversionService(ConversionUtil.getConversionService());
        binder.setFieldDefaultPrefix(StringUtils.isEmpty(name) ? "":name+".");
        binder.bind(request);

        return binder.getTarget();
    }

    @Override
    protected void handleResolvedValue(Object arg, String name, MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) {
        super.handleResolvedValue(arg, name, parameter, mavContainer, webRequest);
//        mavContainer.removeAttributes(bindingResultModel);
//        mavContainer.addAllAttributes(bindingResultModel);
        if(mavContainer.containsAttribute(name)){
            mavContainer.getModel().remove(name);
        }
        if(!StringUtils.isEmpty(name)) {
            mavContainer.getModel().put(name, arg);
        }
    }

    private static class RequestParamNamedValueInfo extends NamedValueInfo {

        public RequestParamNamedValueInfo(Class<?> type) {
            super(type.getSimpleName().toLowerCase(), false, ValueConstants.DEFAULT_NONE);
        }

        public RequestParamNamedValueInfo(Class<?> type, ParamBind annotation) {

            super( StringUtils.isEmpty(annotation.value()) ? type.getSimpleName().toLowerCase() : annotation.value()
                    , annotation.required(), annotation.defaultValue());
        }
    }

    private static class ParamDataBinder extends org.springframework.web.bind.WebDataBinder{

        public ParamDataBinder(Object target, String objectName) {
            super(target, objectName);
        }

        public void bind(NativeWebRequest request) {

            MutablePropertyValues mpvs = new MutablePropertyValues(wrapperParameterMap(request));
            if (request instanceof NativeWebRequest) {
                MultipartRequest multipartRequest = request.getNativeRequest(MultipartRequest.class);
                if (multipartRequest != null) {
                    bindMultipart(multipartRequest.getMultiFileMap(), mpvs);
                }
            }
            doBind(mpvs);
        }


        public Map<String, Object> wrapperParameterMap(NativeWebRequest request) {
            HashMap<String,Object> result = new HashMap<>();

            Map<String, String[]> map = request.getParameterMap();
            for (String s : map.keySet()) {
                String[] v = map.get(s);
                result.put(s, (v.length == 1) ? v[0] : v);
            }

            return result;
        }

    }


}
