package com.smdev.guice.msg.domain.message;

import java.io.Serializable;
import java.util.List;

import com.smdev.guice.msg.domain.user.User;

/**
 * Basic implementation of a message
 *
 * @author Ireth
 */
public abstract class MessageImpl implements Serializable, Message {

	/** */
	private static final long serialVersionUID = -2068022461960625968L;
	private String body;
	private long createTime;
	private List<User> recipients;
	private User sender;

	protected MessageImpl(List<User> recipients, User sender, String body) {
		super();
		this.recipients = recipients;
		this.sender = sender;
		this.body = body;
		this.createTime = System.currentTimeMillis();
	}

	@Override
	public String getBody() {
		return this.body;
	}

	@Override
	public long getCreateTime() {
		return this.createTime;
	}

	@Override
	public List<User> getRecipients() {
		return this.recipients;
	}

	@Override
	public User getSender() {
		return this.sender;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.createTime).append(": from ").append(this.sender.getUserName())
				.append(" to ").append(this.recipients);
		return str.toString();
	}

}
