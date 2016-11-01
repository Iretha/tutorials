package com.smdev.guice.msg.services.impl;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.services.MessageService;

@Singleton
public class ViberService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		//TODO
		System.out.println("Viber Message sent");
		return true;
	}

}
