package com.smdev.guice.msg.service.fb;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.user.UserImpl;

/**
 * Implementation of a facebook user
 *
 * @author Ireth
 */
public class FBUser extends UserImpl {

	@Inject
	public FBUser(@Assisted("userName") String userName, @Assisted("name") String name) {
		super(userName, name);
	}

	// TODO custom implementation
}
