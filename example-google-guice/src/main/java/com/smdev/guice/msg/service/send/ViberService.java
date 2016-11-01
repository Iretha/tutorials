package com.smdev.guice.msg.service.send;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending Viber messages
 * 
 * @author Ireth
 */
@Singleton
public class ViberService implements MessageService {

	@Override
	public boolean send(Message message){
		//TODO
		System.out.println("Viber Message sent");
		return true;
	}

}
