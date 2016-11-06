package com.smdev.lambda.predicate;

import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Predicate;

import com.smdev.lambda.Person;
import com.smdev.lambda.util.Util;

/**
 * Example:
 * {@link http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html}
 *
 * @author Ireth
 */
public class PredicateTest {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		List<Person> list = Util.create(Person.class, "people.txt");

		System.out.println("========= FIRST NAME starts with A ===========");
		Predicate<Person> startsWithA = p -> p.getFirstName().startsWith("A");

		// first option
		list.forEach(p -> {
			if (startsWithA.test(p)) {
				System.out.println(p);
			}
		});

		System.out.println("========= Last NAME ends with A ===========");
		Predicate<Person> endsWithA = p -> p.getSurName().endsWith("a");

		// second option
		list.stream().filter(endsWithA).forEach(System.out::println);
	}
}
