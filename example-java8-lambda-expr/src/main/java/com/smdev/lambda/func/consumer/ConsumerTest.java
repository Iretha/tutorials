package com.smdev.lambda.func.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.smdev.lambda.Person;

/**
 * Consumer can be used in all contexts where an object needs to be consumed,i.e. taken as input,
 * and some operation is to be performed on the object without returning any result.
 * 
 * @author Ireth
 */
public class ConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("===========Example 1==========");
		Consumer<Person> consumer1 = ConsumerTest::printNames;
		consumer1.accept(new Person("firstX", "lastX"));
		consumer1.accept(new Person("firstY", "lastY"));
		consumer1.accept(new Person("firstZ", "lastZ"));

		System.out.println("===========Example 2==========");
		Consumer<Integer> consumer2 = i -> System.out.print(" " + i);
		List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);
		printList(integerList, consumer2);
	}

	private static void printNames(Person p) {
		System.out.println(p);
	}

	public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
		for (Integer integer : listOfIntegers) {
			consumer.accept(integer);
		}
	}
}
