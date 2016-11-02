package com.smdev.guice.msg.service.mail;

import javax.inject.Inject;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.service.LogService;
import com.smdev.guice.msg.service.MessageService;

/**
 * Service for sending e-mails
 * 
 * @author Ireth
 */
public class MailMessageService implements MessageService {

	private LogService logService;

	@Override
	public boolean send(Message message) {
		this.logService.log("Sending message " + message + "...");
		// TODO custom implementation

		return true;
	}

	@Inject
	public void setLogService(@MailType LogService logService) {
		this.logService = logService;
	}
}
