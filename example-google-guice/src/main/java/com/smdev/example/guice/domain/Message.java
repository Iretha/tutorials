package com.smdev.example.guice.domain;

import java.util.List;

public class Message {

	private String body;
	private List<Referent> recipients;
	private Referent sender;

	public Message(List<Referent> recipients, Referent sender, String body) {
		super();
		this.recipients = recipients;
		this.sender = sender;
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public List<Referent> getRecipients() {
		return recipients;
	}

	public Referent getSender() {
		return sender;
	}

}
