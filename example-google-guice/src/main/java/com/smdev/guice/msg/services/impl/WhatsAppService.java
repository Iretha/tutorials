package com.smdev.guice.msg.services.impl;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.services.MessageService;

@Singleton
public class WhatsAppService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		//TODO
		System.out.println("WhatsApp Message sent");
		return true;
	}

}
