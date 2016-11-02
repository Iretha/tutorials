package com.smdev.guice.msg.service;

import com.smdev.guice.msg.domain.message.Message;

/**
 * Service for sending messages
 * 
 * @author Ireth
 */
public interface MessageService {

	/**
	 * Send a message
	 * 
	 * @param message
	 * @return true/ false
	 */
	boolean send(Message message);
}
