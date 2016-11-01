package com.smdev.example.guice.services.impl;

import javax.inject.Singleton;

import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.MessageException;
import com.smdev.example.guice.services.MessageService;

@Singleton
public class WhatsAppService implements MessageService {

	@Override
	public boolean sendMessage(Message message) throws MessageException {
		//TODO
		System.out.println("WhatsApp Message sent");
		return true;
	}

}
