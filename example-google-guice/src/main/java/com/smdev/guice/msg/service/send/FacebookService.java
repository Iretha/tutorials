package com.smdev.guice.msg.service.send;

import javax.inject.Singleton;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending Facebook messages
 * 
 * @author Ireth
 */
@Singleton
public class FacebookService implements MessageService {

	@Override
	public boolean send(Message message) {
		// TODO
		System.out.println("FB Message sent");
		return true;
	}

}
