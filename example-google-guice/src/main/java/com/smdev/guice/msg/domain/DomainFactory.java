package com.smdev.guice.msg.domain;

import java.util.List;

import com.google.inject.assistedinject.Assisted;
import com.smdev.guice.msg.domain.message.Message;
import com.smdev.guice.msg.domain.user.User;

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
	Message createMessage(@Assisted("recipients") List<User> recipients, @Assisted("sender") User sender, String body);

	/**
	 * Creates an instance of {@link User}
	 * 
	 * @Assisted - we have to annotate all params of the same type
	 * 
	 * @param userName
	 * @param name
	 * @return new instance
	 */
	User createUser(@Assisted("userName") String userName, @Assisted("name") String name);
}
