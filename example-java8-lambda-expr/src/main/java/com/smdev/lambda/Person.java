/**
 * 
 */
package com.smdev.lambda;

import java.util.function.Function;

/**
 * @author Ireth
 */
public class Person {

	private String firstName;
	private String surName;

	public Person() {
		super();
	}

	public Person(String firstName, String surName) {
		super();
		this.firstName = firstName;
		this.surName = surName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return this.surName;
	}

	/**
	 * @param surName
	 *            the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return this.firstName + " " + this.surName;
	}

	public String apply(Function<Person, String> f) {
		return f.apply(this);
	}
}
