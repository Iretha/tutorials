package com.smdev.guice.msg.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a message that can be exchanged between different correspondents
 * 
 * @author Ireth
 */
public class Message implements Serializable {

	/** */
	private static final long serialVersionUID = -2068022461960625968L;
	private String body;
	private List<MessageCorrespondent> recipients;
	private MessageCorrespondent sender;

	public Message(List<MessageCorrespondent> recipients, MessageCorrespondent sender, String body) {
		super();
		this.recipients = recipients;
		this.sender = sender;
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public List<MessageCorrespondent> getRecipients() {
		return recipients;
	}

	public MessageCorrespondent getSender() {
		return sender;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Msg from ").append(sender.getName()).append(" to ").append(recipients);
		return str.toString();
	}

}
