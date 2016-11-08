package com.smdev.spring.msg.domain.user;

/**
 * Basic implementation of a user
 *
 * @author Ireth
 */
public abstract class UserImpl implements User {
	private String name;
	private String userName;

	protected UserImpl(String userName, String name) {
		super();
		this.userName = userName;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getUserName() {
		return this.userName;
	}

	@Override
	public String toString() {
		return this.userName;
	}
}
