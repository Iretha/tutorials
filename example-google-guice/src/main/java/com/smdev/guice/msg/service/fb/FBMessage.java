package com.smdev.guice.msg.service.fb;

import java.util.List;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.message.MessageImpl;
import com.smdev.guice.msg.domain.user.User;

/**
 * Implementation of a facebook message
 *
 * @author Ireth
 */
public class FBMessage extends MessageImpl {

	/** */
	private static final long serialVersionUID = 1104389967485682554L;

	@Inject
	public FBMessage(@Assisted("recipients") List<User> recipients, @Assisted("sender") User sender,
			String body) {
		super(recipients, sender, body);
	}

	// TODO custom implementation
}
