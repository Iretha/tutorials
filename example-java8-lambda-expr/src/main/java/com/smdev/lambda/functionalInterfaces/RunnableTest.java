package com.smdev.lambda.functionalInterfaces;

/**
 * A functional interface, introduced in Java 8, is an interface which has only a single abstract
 * method. Conversely, if you have any interface which has only a single abstract method, then that
 * will effectively be a functional interface. This interface can then be used anywhere where a
 * functional interface is eligible to be used.
 * 
 * Example:
 * {@link http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html}
 *
 * @author Ireth
 */
public class RunnableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ================= OLD ===========================
		// Anonymous Runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("r1 is running...");
			}
		};
		r1.run();

		// ================= NEW ===========================
		// Lambda Runnable
		Runnable r2 = () -> System.out.println("r2 is running...");
		r2.run();
	}

}
