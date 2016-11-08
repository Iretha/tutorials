package com.smdev.spring.msg.service.mail;

import com.smdev.spring.msg.domain.user.UserImpl;

/**
 * Implementation of an email user
 *
 * @author Ireth
 */
public class MailUser extends UserImpl {

	public MailUser(String userName, String name) {
		super(userName, name);
	}

	public String getEmail() {
		return getUserName();
	}

	// TODO custom implementation

}
