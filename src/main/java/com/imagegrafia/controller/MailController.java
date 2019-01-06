package com.imagegrafia.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagegrafia.model.EmailTemplate;
import com.imagegrafia.service.EmailService;

@RestController
public class MailController {

	
	
	@Autowired
	private EmailService emailService;

	@RequestMapping("/mail/{id}")
	public String sendMail(@PathVariable("id") int id) throws MessagingException {
		//fetch email template from db
		return this.sendEmail(emailService.getEmailTemplate(id).get());

	}

	//logic to send mail
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmail(EmailTemplate emailTemplate) {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true); // true indicates multipart message
			helper.setSubject(emailTemplate.getSubject());
			helper.setTo(emailTemplate.getEmail());
			helper.setText(emailTemplate.getMessage(), true);// true indicates html we cann add attachment
			
		} catch (MessagingException me) {
			me.printStackTrace();
			return "Error while sending mail ..";
		}
		javaMailSender.send(message);
		return "mail sent succesfully";

	}
}