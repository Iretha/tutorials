package com.smdev.spring.msg.domain;

import java.util.List;

import com.smdev.spring.msg.domain.msg.Message;
import com.smdev.spring.msg.domain.user.User;

/**
 * Factory for domain object types
 *
 * @author Ireth
 */
public interface DomainFactory {

	/**
	 * Creates an instance of {@link Message}
	 *
	 * @Assisted - we have to annotate only params of the same type
	 *
	 * @param recipients
	 *            - message recipients
	 * @param sender
	 *            - message sender
	 * @param body
	 *            - message body
	 * @return new instance
	 */
	Message createMessage(List<User> recipients, User sender, String body);

	/**
	 * Creates an instance of {@link User}
	 *
	 * @Assisted - we have to annotate all params of the same type
	 *
	 * @param userName
	 * @param name
	 * @return new instance
	 */
	User createUser(String userName, String name);
}
