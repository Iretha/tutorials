/**
 * 
 */
package com.smdev.lambda.aa.builder;

import com.smdev.lambda.Person;

/**
 * @author Ireth
 */
public class BuilderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person p1 = GenericBuilder.of(Person::new).with(Person::setFirstName, "FirstNameX")
				.with(Person::setSurName, "SurNameX").build();

		System.out.println(p1);
	}

}
