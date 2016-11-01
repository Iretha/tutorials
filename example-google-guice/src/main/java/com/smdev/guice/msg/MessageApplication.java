package com.smdev.guice.msg;

import javax.inject.Inject;
import javax.inject.Named;

import com.smdev.guice.msg.domain.AppException;
import com.smdev.guice.msg.domain.Message;
import com.smdev.guice.msg.services.BackupService;
import com.smdev.guice.msg.services.MessageService;

/**
 * Simple application for sending messages
 * 
 * @author Ireth
 */
public class MessageApplication {

	/** Message backup service */
	private BackupService backupService = null;;

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
	public MessageApplication(BackupService backupService) {
		super();
		this.backupService = backupService;
	}

	/**
	 * Sends a message
	 * 
	 * @param message
	 * @return boolean
	 * @throws AppException
	 */
	public boolean sendMessage(Message message) throws AppException {
		this.backupService.backup(System.currentTimeMillis(), message);

		boolean sent = false;
		int attempts = 1;
		sent = this.messageService.sendMessage(message);
		while (!sent && attempts <= MAX_RETRY_ATTEMPTS) {
			sent = this.messageService.sendMessage(message);
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
	public void setMessageService(MessageService service) {
		this.messageService = service;
	}

}
