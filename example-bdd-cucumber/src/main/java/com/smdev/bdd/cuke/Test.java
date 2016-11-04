/**
 * 
 */
package com.smdev.bdd.cuke;

/**
 * @author Ireth
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.err.println("a");
		try {
			System.err.println("b");
			throw new IllegalAccessException();
		} catch (IllegalAccessException e) {
			try {
				System.err.println("c");
				throw new RuntimeException("1");
			} catch (RuntimeException e1) {
				System.err.println("d");
				throw new RuntimeException("2");
			}
		} finally {
			System.err.println("e");
			throw new RuntimeException("3");
		}

	}

}
