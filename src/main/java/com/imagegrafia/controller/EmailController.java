package com.imagegrafia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagegrafia.model.EmailTemplate;
import com.imagegrafia.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/send/{id}")
	public Optional<EmailTemplate> sendEmail(@PathVariable("id") int id) {
		
		return emailService.getEmailTemplate(id);
	}
}
