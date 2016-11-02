package com.smdev.guice.msg.service.send;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending Facebook messages
 * 
 * @author Ireth
 */
public class FacebookService implements MessageService {

	@Override
	public boolean send(Message message) {
		// TODO custom implementation
		System.out.println("FB Message sent " + message);
		return true;
	}
}
