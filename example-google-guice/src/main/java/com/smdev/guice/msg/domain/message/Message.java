package com.smdev.guice.msg.domain.message;

import java.util.List;

import com.smdev.guice.msg.domain.user.User;

public interface Message {

	String getBody();

	long getCreateTime();

	List<User> getRecipients();

	User getSender();
}
