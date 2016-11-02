package com.smdev.guice.msg.service.fb;

import com.smdev.guice.msg.domain.message.Message;
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
