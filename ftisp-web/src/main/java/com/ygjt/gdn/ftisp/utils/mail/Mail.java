package com.ygjt.gdn.ftisp.utils.mail;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class Mail {

    private static Logger logger = Logger.getLogger(Mail.class);

    public static void sendMail(EmailMessage emailMessage) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", emailMessage.getHost());
        props.put("mail.smtp.auth", "true");
        System.out.println(props);
        EmailAutherticator auth = new EmailAutherticator(emailMessage.getUsername(), emailMessage.getPassword());
        Session session = Session.getDefaultInstance(props, auth);

        MimeMessage message = new MimeMessage(session);
        message.setContent("Hello", "text/plain");
        logger.info(emailMessage.getSubject());
        message.setSubject(emailMessage.getSubject(), "utf-8");// 设置邮件主题
        message.setSentDate(new Date());// 设置邮件发送时期
        Address address = new InternetAddress(emailMessage.getFrom(), emailMessage.getSubject(), "utf-8");

        //message.setFrom(address);// 设置邮件发送者的地址
        message.setFrom(new InternetAddress(MimeUtility.encodeText(emailMessage.getNick())+" <"+emailMessage.getFrom()+">"));
        Address toaddress = new InternetAddress(emailMessage.getTo());// 设置邮件接收者的地址
        message.addRecipient(Message.RecipientType.TO, toaddress);
        // 创建一个包含HTML内容的MimeBodyPart
        Multipart mainPart = new MimeMultipart();
        BodyPart html = new MimeBodyPart();
        html.setContent(emailMessage.getBody(), "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);

        System.out.println(message);
        logger.debug("TO:" + emailMessage.getBody());
        Transport.send(message);
        System.out.println("Send Mail Ok!");
    }


}