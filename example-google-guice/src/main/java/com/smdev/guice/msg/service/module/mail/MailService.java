package com.smdev.guice.msg.service.module.mail;

import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending e-mails
 * 
 * @author Ireth
 */
public class MailService implements MessageService {

	@Override
	public boolean send(Message message){
		// TODO custom implementation
		System.out.println("Email Message sent: " + message);
		return true;
	}
}
