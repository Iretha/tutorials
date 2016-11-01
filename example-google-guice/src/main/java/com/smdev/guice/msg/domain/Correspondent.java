package com.smdev.guice.msg.domain;

/**
 * A person, who can send or receive messages
 * 
 * @author Ireth
 */
public class Correspondent {

	private String address;
	private String name;

	public Correspondent(String address, String name) {
		super();
		this.address = address;
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
