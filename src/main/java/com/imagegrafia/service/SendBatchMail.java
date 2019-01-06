package com.imagegrafia.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.imagegrafia.model.EmailTemplate;

@Configuration
@EnableScheduling
public class SendBatchMail {

	@Autowired
	private EmailService emailService;

	int x=0;
	@Scheduled(cron = "*/5 * * * * *")
	public void sendMail() throws MessagingException {
		x++;
		//fetch email template from db
		 this.sendEmail(emailService.getEmailTemplate(1).get());
		 System.out.println("mail is being sent from batch..."+x);

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
