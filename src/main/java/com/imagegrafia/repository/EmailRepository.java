package com.imagegrafia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imagegrafia.model.EmailTemplate;
@Repository
public interface EmailRepository extends JpaRepository<EmailTemplate, Integer> {
	
	

}
