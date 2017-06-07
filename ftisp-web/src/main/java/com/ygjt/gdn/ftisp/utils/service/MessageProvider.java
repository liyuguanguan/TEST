package com.ygjt.gdn.ftisp.utils.service;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * Created by Je on 2016/11/16.
 */
public class MessageProvider implements MessageSourceAware {
    protected MessageSourceAccessor message;

    /**
     * 获取多语言配置的提示信息
     * @param code 信息编码
     * @param args 可变参数
     * @return
     */
    protected String getMessage(String code,Object... args){
        return this.message.getMessage(code,args);
    }

    protected String getMessage(String code){
        return this.message.getMessage(code);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.message = new MessageSourceAccessor(messageSource) ;
    }
}
