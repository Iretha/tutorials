package com.smdev.spring.msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.service.BackupService;
import com.smdev.spring.msg.service.MessageService;

/**
 * Simple application for sending messages
 *
 * @author Ireth
 */
@Component
public class MessageConfigWithAnnotApp {

	/** Message backup service */
	private BackupService backupService = null;

	/** Max attempts to try sending the message */
	@Value("${MAX_RETRY_ATTEMPTS:2}")
	private String MAX_RETRY_ATTEMPTS = null;

	/** Message service */
	private MessageService messageService;

	/**
	 * Constructor injection example
	 *
	 * @param backupService
	 */
	@Autowired
	public MessageConfigWithAnnotApp(MessageService messageService) {
		super();
		this.messageService = messageService;
	}

	/**
	 * Sends a message
	 *
	 * @param message
	 * @return boolean
	 * @throws MessageAppException
	 */
	public boolean sendMessage(Message message) throws MessageAppException {
		this.backupService.backup(message);

		boolean sent = false;
		int attempts = 1;
		sent = this.messageService.send(message);
		while (!sent && attempts <= Integer.valueOf(this.MAX_RETRY_ATTEMPTS)) {
			sent = this.messageService.send(message);
			attempts++;
		}
		return sent;
	}

	/**
	 * Setter injection example
	 *
	 * @param service
	 */
	@Autowired
	public void setBackupService(BackupService service) {
		this.backupService = service;
	}
}
