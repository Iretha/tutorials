package com.smdev.lambda.functionalInterfaces.custom;

/**
 * @author Ireth
 */
public class PrintableTest {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Printable p = (s) -> {
			System.out.println(s);
			return s;
		};

		p.print("AA");
		p.print("BB");
		p.print("CC");
	}
}
