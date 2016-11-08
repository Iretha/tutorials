package com.smdev.spring.msg.service.fb;

import java.util.List;

import com.smdev.spring.msg.domain.msg.MessageImpl;
import com.smdev.spring.msg.domain.user.User;

/**
 * Implementation of a facebook message
 *
 * @author Ireth
 */
public class FBMessage extends MessageImpl {

	/** */
	private static final long serialVersionUID = 1104389967485682554L;

	public FBMessage(List<User> recipients, User sender, String body) {
		super(recipients, sender, body);
	}

	// TODO custom implementation
}
