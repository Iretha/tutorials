package com.smdev.lambda.functionalInterfaces.custom;

/**
 * @author Ireth
 */
@FunctionalInterface
public interface Printable {

	/**
	 * Function Descriptor is a term used to describe the signature of the abstract method of a
	 * Functional Interface: (String) -> void example
	 * 
	 * @param s
	 * @throws Exception
	 */
	void print(String s) throws Exception;
}
