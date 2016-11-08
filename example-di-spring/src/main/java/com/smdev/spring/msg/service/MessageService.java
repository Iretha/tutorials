package com.smdev.spring.msg.service;

import com.smdev.spring.msg.domain.msg.Message;

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
