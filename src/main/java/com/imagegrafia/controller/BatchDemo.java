package com.imagegrafia.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imagegrafia.service.EmailService;

@Configuration
@EnableScheduling
public class BatchDemo {

	@Scheduled(cron = "*/2 * * * * *")
	public void perform() throws Exception {
			System.out.println("writeen from batch");
	}
	
}
