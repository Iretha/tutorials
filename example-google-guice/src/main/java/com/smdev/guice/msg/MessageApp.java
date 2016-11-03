package com.smdev.guice.msg;

import javax.inject.Inject;
import javax.inject.Named;

import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.service.BackupService;
import com.smdev.guice.msg.service.MessageService;

/**
 * Simple application for sending messages
 *
 * @author Ireth
 */
public class MessageApp {

	/** Message backup service */
	private BackupService backupService = null;

	/** Max attempts to try sending the message */
	@Inject
	@Named("MAX_RETRY_ATTEMPTS")
	private Integer MAX_RETRY_ATTEMPTS = null;

	/** Message service */
	private MessageService messageService;

	/**
	 * Constructor injection example
	 *
	 * @param backupService
	 */
	@Inject
	public MessageApp(MessageService messageService) {
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
		while (!sent && attempts <= this.MAX_RETRY_ATTEMPTS) {
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
	@Inject
	public void setBackupService(BackupService service) {
		this.backupService = service;
	}
}
