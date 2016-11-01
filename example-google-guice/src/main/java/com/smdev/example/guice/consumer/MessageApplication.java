package com.smdev.example.guice.consumer;

import javax.inject.Inject;
import javax.inject.Named;

import com.smdev.example.guice.domain.AppException;
import com.smdev.example.guice.domain.Message;
import com.smdev.example.guice.services.BackupService;
import com.smdev.example.guice.services.MessageService;

public class MyApplication {

	/**
	 * Message backup service
	 */
	private BackupService backupService = null;;

	/**
	 * Max attempts to try sending the message
	 */
	@Inject
	@Named("MAX_RETRY_ATTEMPTS")
	private Integer MAX_RETRY_ATTEMPTS = null;

	/**
	 * Message service
	 */
	private MessageService messageService;

	/**
	 * Constructor injection
	 * 
	 * @param backupService
	 */
	@Inject
	public MyApplication(BackupService backupService) {
		super();
		this.backupService = backupService;
	}

	/**
	 * Sending a message
	 * 
	 * @param message
	 * @return boolean
	 * @throws AppException
	 */
	public boolean sendMessage(Message message) throws AppException {
		int attempts = 1;
		boolean sent = false;

		this.backupService.backup(System.currentTimeMillis(), message);

		sent = this.messageService.sendMessage(message);
		while (!sent && attempts <= MAX_RETRY_ATTEMPTS) {
			sent = this.messageService.sendMessage(message);
			attempts++;
		}

		return sent;
	}

	/**
	 * Setter injection
	 * 
	 * @param service
	 */
	@Inject
	public void setMessageService(MessageService service) {
		this.messageService = service;
	}

}
