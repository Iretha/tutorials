package com.smdev.spring.msg.service.mail;

import javax.annotation.Resource;

import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.service.ActivityService;
import com.smdev.spring.msg.service.MessageService;

/**
 * Service for sending e-mails
 *
 * @author Ireth
 */
public class MailMessageService implements MessageService {

	@Resource(name = "mailActivity")
	private ActivityService mailActivity;

	@Override
	public boolean send(Message message) {
		this.mailActivity.track("Sending message " + message + "...");
		// TODO custom implementation

		return true;
	}
}
