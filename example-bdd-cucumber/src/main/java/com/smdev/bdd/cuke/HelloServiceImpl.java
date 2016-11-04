/**
 *
 */
package com.smdev.bdd.cuke;

/**
 * @author Ireth
 *
 */
public class HelloServiceImpl implements HelloService {

	/** @see com.smdev.bdd.cuke.HelloService#sayHello(java.lang.String) */
	@Override
	public String sayHello(String personName) {
		return "Hello, " + personName;
	}

}
