package com.smdev.lambda.func.function;

import java.net.URISyntaxException;
import java.util.List;
import java.util.function.Function;

import com.smdev.lambda.Person;
import com.smdev.lambda.util.Util;

/**
 * The primary purpose for which Function<T, R> has been created is for mapping scenarios i.e when
 * an object of a type is taken as input and its is converted(or mapped) to another type.
 * 
 * Example:
 * {@link http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html}
 *
 * @author Ireth
 */
public class FunctionTest {

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {
		List<Person> list = Util.create(Person.class, "people.txt");

		System.out.println("=============== Example 1 =====================");
		Function<Person, String> firstLast = p -> p.getFirstName() + " " + p.getSurName();
		Function<Person, String> lastFirst = p -> p.getSurName() + " " + p.getFirstName();
		list.forEach(
				p -> System.out.println(p.applyFunc(firstLast) + " <-> " + p.applyFunc(lastFirst)));

		System.out.println("=============== Example 2 =====================");
		Function<Person, String> funcPersonToSurName = (Person p) -> {
			return p.getSurName();
		};
		list.forEach(p -> System.out.println(p.applyFunc(funcPersonToSurName)));
	}

}
