package com.smdev.lambda.func.supplier;

import java.util.function.Supplier;

import com.smdev.lambda.Person;

/**
 * Supplier<T> is an in-built functional interface introduced in Java 8 in the java.util.function
 * package. Supplier can be used in all contexts where there is no input but an output is expected.
 * 
 * @author Ireth
 */
public class SupplierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Supplier<Person> personGenerator = SupplierTest::personMaker;

		for (int i = 0; i < 10; i++) {
			System.out.println("#" + i + ": " + personGenerator.get());
		}

	}

	public static Person personMaker() {
		return new Person("A", "B");
	}

}
