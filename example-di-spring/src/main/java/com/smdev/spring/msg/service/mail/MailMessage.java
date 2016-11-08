package com.smdev.spring.msg.service.mail;

import java.util.List;

import com.smdev.spring.msg.domain.msg.MessageImpl;
import com.smdev.spring.msg.domain.user.User;

/**
 * Implementation of an email message
 *
 * @author Ireth
 */
public class MailMessage extends MessageImpl {

	/** */
	private static final long serialVersionUID = 1104389967485682554L;

	public MailMessage(List<User> recipients, User sender, String body) {
		super(recipients, sender, body);
	}

	// TODO custom implementation
}
