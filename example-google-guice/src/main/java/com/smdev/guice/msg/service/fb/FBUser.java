package com.smdev.guice.msg.service.fb;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.user.UserImpl;

public class FBUser extends UserImpl {

	@Inject
	public FBUser(@Assisted("userName") String userName, @Assisted("name") String name) {
		super(userName, name);
	}
}
