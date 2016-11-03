package com.smdev.guice.msg.service.mail;

import java.util.List;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.message.MessageImpl;
import com.smdev.guice.msg.domain.user.User;

/**
 * Implementation of an email message
 *
 * @author Ireth
 */
public class MailMessage extends MessageImpl {

	/** */
	private static final long serialVersionUID = 1104389967485682554L;

	@Inject
	public MailMessage(@Assisted("recipients") List<User> recipients,
			@Assisted("sender") User sender, String body) {
		super(recipients, sender, body);
	}

	// TODO custom implementation
}
