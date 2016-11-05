/**
 * 
 */
package com.smdev.lambda.function;

import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Function;

import com.smdev.lambda.Person;
import com.smdev.lambda.util.Util;

/**
 * @author Ireth
 */
public class FunctionTest {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		List<Person> list = Util.create(Person.class, "people.txt");

		Function<Person, String> firstLast = p -> p.getFirstName() + " " + p.getSurName();
		Function<Person, String> lastFirst = p -> p.getSurName() + " " + p.getFirstName();
		list.forEach(p -> System.out.println(p.apply(firstLast) + " <-> " + p.apply(lastFirst)));
	}

}
