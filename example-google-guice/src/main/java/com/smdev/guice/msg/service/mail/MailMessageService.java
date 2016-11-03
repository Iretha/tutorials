package com.smdev.guice.msg.service.mail;

import javax.inject.Inject;

import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.service.ActivityService;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending e-mails
 *
 * @author Ireth
 */
public class MailMessageService implements MessageService {

	@Inject
	private @MailType ActivityService mailActivity;

	@Override
	public boolean send(Message message) {
		this.mailActivity.track("Sending message " + message + "...");
		// TODO custom implementation

		return true;
	}
}
