package com.smdev.lambda.func.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.smdev.lambda.Person;

/**
 * Supplier<T> is an in-built functional interface introduced in Java 8 in the java.util.function
 * package. Supplier can be used in all contexts where there is no input but an output is expected.
 * 
 * @author Ireth
 */
public class SupplierWithStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("AA", "AAA"));
		list.add(new Person("BB", "BBB"));
		list.add(new Person("CC", "CCC"));
		Stream<String> names = list.stream().map(Person::getFirstName);
		names.forEach(System.out::println);
	}

}
