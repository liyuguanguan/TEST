package com.ygjt.gdn.ftisp.mail.service;

import java.io.IOException;

/**
 * 邮件处理类
 * Created by linx on 2017-04-14.
 */
public interface MailService<K>   {
    String replaceBody(K mailData, String template)throws IOException;
    boolean send(K mailData) throws IOException;
}
