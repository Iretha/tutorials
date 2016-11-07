package com.smdev.lambda.streams;

import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.smdev.lambda.Person;
import com.smdev.lambda.util.Util;

/**
 * @author Ireth
 */
public class FilterStreamTest {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		List<Person> list = Util.create(Person.class, "people.txt");

		System.out.println("FirstName starts with D:");
		Predicate<Person> predicate = p -> p.getFirstName().startsWith("D");
		List<Person> filtered = list.stream().filter(predicate).collect(Collectors.toList());
		filtered.forEach(System.out::println);
	}

}
