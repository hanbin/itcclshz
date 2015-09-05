/* 
 * 邮件发送类使用SaeMail服务
 */
package com.itcc.dao;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Icer
 */
public class SendMail {

	private String host = "smtp.qq.com";
	private String user = "313949302@qq.com";
	private String pwd = "woaini@123";
	private String from = "313949302@qq.com";
	
	
    public boolean sendMail(String username, String email, String password) {
        boolean flag = false;
        String content = "您好" + username + "，您在IT菜菜--收支管理平台注册的帐号密码为：" + password + ""
                + "<br>您可以点击这里进行登录：<a href='http://itcclshz.sinaapp.com/' target='_blank'>收支平台</a>" + ""
                + ".<br>同时，您也可以点击这里查看我们的主站：<a href='http://itcaicai.com' target='_blank'>IT菜菜</a>." + ""
                + ".<br>最后，IT菜菜祝您生活愉快，希望我们的系统能给您带来方便";
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.auth", true);
        
        Session session = Session.getDefaultInstance(prop);
        session.setDebug(true);
        
        MimeMessage message = new MimeMessage(session);
        
        try {
        	message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("IT菜菜--收支管理平台密码");
            Multipart multipart = new MimeMultipart();
            
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(content);
            multipart.addBodyPart(contentPart);
            
            message.setContent(multipart);
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, user, pwd);
			transport.sendMessage(message, message.getAllRecipients());
			flag = true;
		} catch (MessagingException e) {
			e.printStackTrace();
			flag = false;
		}
        
        return flag;
    }
    
}
