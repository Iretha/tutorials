package com.smdev.example.guice.consumer;

import javax.inject.Inject;

import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.MessageException;
import com.smdev.example.guice.services.MessageService;

public class MyApplication {

	private MessageService service;

	public boolean sendMessage(Message message) throws MessageException {
		//TODO some business logic here
		return this.service.sendMessage(message);
	}

	@Inject
	public void setService(MessageService service) {
		this.service = service;
	}

}
