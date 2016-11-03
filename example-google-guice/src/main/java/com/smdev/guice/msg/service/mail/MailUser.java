package com.smdev.guice.msg.service.mail;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.user.UserImpl;

/**
 * Implementation of an email user
 *
 * @author Ireth
 */
public class MailUser extends UserImpl {

	@Inject
	public MailUser(@Assisted("userName") String userName, @Assisted("name") String name) {
		super(userName, name);
	}

	public String getEmail() {
		return getUserName();
	}

	// TODO custom implementation

}
