package com.smdev.guice.msg.service.send;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

@Singleton
public class WhatsAppService implements MessageService {

	@Override
	public boolean sendMessage(Message message){
		//TODO
		System.out.println("WhatsApp Message sent");
		return true;
	}

}
