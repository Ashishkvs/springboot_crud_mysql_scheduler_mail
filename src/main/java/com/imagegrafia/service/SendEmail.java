//package com.imagegrafia.service;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SendEmail {
//	
//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	
//	public String send(String to,String subject,String body) {
//		
//		MimeMessage message=javaMailSender.createMimeMessage();
//		MimeMessageHelper helper;
//		try {
//		helper=new MimeMessageHelper(message, true); //true indicates multipart message
//		helper.setSubject(subject);
//		helper.setTo(to);
//		helper.setText(body,true);//true indicates html we cann add attachment
//		//javaMailSender.send(message);
//		}
//		catch(MessagingException me) {
//			me.printStackTrace();
//			 return "Error while sending mail ..";
//		}
//		javaMailSender.send(message);
//		return "mail sent succesfully";
//		
//	}
//}