package com.smdev.spring.msg;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.smdev.spring.msg.domain.Type;
import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.service.BackupService;
import com.smdev.spring.msg.service.MessageService;

/**
 * Simple application for sending messages
 *
 * @author Ireth
 */
@Component
public class MessageApp {

	/** Message backup service */
	private BackupService backupService = null;

	/** Max attempts to try sending the message */
	@Value("${MAX_RETRY_ATTEMPTS:2}")
	private String MAX_RETRY_ATTEMPTS = null;

	/** FB Message service */
	private MessageService fbMessageService;

	/** Mail Message service */
	private MessageService mailMessageService;

	/**
	 * Constructor injection example
	 *
	 * @param backupService
	 */
	@Autowired
	public MessageApp(BackupService backupService) {
		super();
		this.backupService = backupService;
	}

	/**
	 * Sends a message
	 *
	 * @param message
	 * @return boolean
	 * @throws MessageAppException
	 */
	public boolean sendMessage(Type type, Message message) throws MessageAppException {
		this.backupService.backup(message);

		boolean sent = false;
		int attempts = 1;

		MessageService messageService = (type == Type.FB) ? this.fbMessageService
				: this.mailMessageService;

		sent = messageService.send(message);
		while (!sent && attempts <= Integer.valueOf(this.MAX_RETRY_ATTEMPTS)) {
			sent = messageService.send(message);
			attempts++;
		}
		return sent;
	}

	/**
	 * @param fbMessageService
	 *            the fbMessageService to set
	 */
	@Autowired
	@Resource(name = "fbMessageService")
	public void setFbMessageService(MessageService fbMessageService) {
		this.fbMessageService = fbMessageService;
	}

	/**
	 * @param mailMessageService
	 *            the mailMessageService to set
	 */
	@Autowired
	@Resource(name = "mailMessageService")
	public void setMailMessageService(MessageService mailMessageService) {
		this.mailMessageService = mailMessageService;
	}

}
