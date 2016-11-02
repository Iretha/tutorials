package com.smdev.guice.msg.domain.user;

import com.google.inject.assistedinject.Assisted;

public interface UserFactory {

	User createUser(@Assisted("userName") String userName, @Assisted("name") String name);
}
