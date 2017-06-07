package com.ygjt.gdn.ftisp.mail.service;

import com.ygjt.gdn.ftisp.mail.model.BaseMailData;
import com.ygjt.gdn.ftisp.utils.mail.EmailMessage;
import com.ygjt.gdn.ftisp.utils.mail.Mail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;

/**
 * Created by linx on 2017-04-14.
 */
public abstract class AbstractMailService<K> implements MailService<K> {
    private static final Logger logger = Logger.getLogger(AbstractMailService.class);
    @Value("#{configProperties['register.mail.path']}")
    private String templatePath;


    @Value("#{configProperties['mail.host']}")
    private String host;
    @Value("#{configProperties['mail.nick']}")
    private String nick;
    @Value("#{configProperties['mail.from']}")
    private String from;
    @Value("#{configProperties['mail.username']}")
    private String username;
    @Value("#{configProperties['mail.password']}")
    private String password;



    public void sendMail(BaseMailData baseMailData) throws Exception {
        EmailMessage message = new EmailMessage();
        message.setHost(host);
        message.setNick(nick);
        message.setFrom(from);
        message.setUsername(username);
        message.setPassword(password);
        message.setTo(baseMailData.getTo());
        message.setSubject(baseMailData.getSubject());
        message.setBody(baseMailData.getBody());
        Mail.sendMail(message);
    }

    /**
     * 读取模板
     *
     * @param filename
     * @return
     * @throws IOException
     */
    protected String readMsg(String filename) throws IOException {
        StringBuffer sb = new StringBuffer();
        InputStream fis = Mail.class.getResourceAsStream(filename);
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(fis, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("读取文件遇见不正确的文件编码！", e);
        }
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }
}
