package com.smdev.lambda.refrences;

import java.util.function.Function;

/**
 * @author Ireth
 */
public class StaticMethodReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function<String, Double> doubleConvertor = Double::parseDouble;
		System.out.println("method reference: " + doubleConvertor.apply("0.254"));

		Function<String, Double> doubleConvertorLambda = (String s) -> Double.parseDouble(s);
		System.out.println("lambda: " + doubleConvertorLambda.apply("0.254"));
	}

}
