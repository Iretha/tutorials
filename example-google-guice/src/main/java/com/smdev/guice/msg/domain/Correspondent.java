package com.smdev.guice.msg.domain;

/**
 * A person, who can send or receive messages
 * 
 * @author Ireth
 */
public class Correspondent {

	private String name;
	private String userName;

	public Correspondent(String userName, String name) {
		super();
		this.userName = userName;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return this.userName;
	}

}
