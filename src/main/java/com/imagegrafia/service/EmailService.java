package com.imagegrafia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imagegrafia.model.EmailTemplate;
import com.imagegrafia.repository.EmailRepository;
@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;
	
	public Optional<EmailTemplate> getEmailTemplate(int id) {
		
		return emailRepository.findById(id);
	}
	/**
	 * from info@abc.com to all with this particualr template
	 */
	
}
