package com.imagegrafia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmailTemplate {

	@Id
	private int id;
	private String email;
	private String message;
	private String subject;
	private String attachment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "EmailTemplate [id=" + id + ", email=" + email + ", message=" + message + ", subject=" + subject
				+ ", attachment=" + attachment + "]";
	}
	
	
}
