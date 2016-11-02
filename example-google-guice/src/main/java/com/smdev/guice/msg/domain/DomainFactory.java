package com.smdev.guice.msg.domain;

import java.util.List;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.domain.user.User;

public interface DomainFactory {

	Message create(@Assisted("recipients") List<User> recipients, @Assisted("sender") User sender, String body);

	User create(@Assisted("userName") String userName, @Assisted("name") String name);
}
