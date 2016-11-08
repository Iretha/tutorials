package com.smdev.spring.msg.domain.msg;

import java.util.List;

import com.smdev.spring.msg.domain.user.User;

/**
 * Represents a message that can be exchanged between different users
 *
 * @author Ireth
 */
public interface Message {

	/**
	 * @return message body
	 */
	String getBody();

	/**
	 * @return message create time
	 */
	long getCreateTime();

	/**
	 * @return list of recipients
	 */
	List<User> getRecipients();

	/**
	 * @return message sender
	 */
	User getSender();
}
