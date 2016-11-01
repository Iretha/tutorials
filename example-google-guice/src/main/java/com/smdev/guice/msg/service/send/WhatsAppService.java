package com.smdev.guice.msg.service.send;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending WhatsApp messages
 * 
 * @author Ireth
 */
@Singleton
public class WhatsAppService implements MessageService {

	@Override
	public boolean send(Message message){
		// TODO impl me
		System.out.println("WhatsApp Message sent");
		return true;
	}

}
