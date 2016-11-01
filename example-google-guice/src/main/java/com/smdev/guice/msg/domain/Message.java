package com.smdev.guice.msg.domain;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

	/** */
	private static final long serialVersionUID = -2068022461960625968L;
	private String body;
	private List<MessageReferent> recipients;
	private MessageReferent sender;

	public Message(List<MessageReferent> recipients, MessageReferent sender, String body) {
		super();
		this.recipients = recipients;
		this.sender = sender;
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public List<MessageReferent> getRecipients() {
		return recipients;
	}

	public MessageReferent getSender() {
		return sender;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Msg from ").append(sender.getName()).append(" to ").append(recipients);
		return str.toString();
	}

}
