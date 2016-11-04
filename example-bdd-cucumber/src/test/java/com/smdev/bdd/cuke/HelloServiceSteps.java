/**
 *
 */
package com.smdev.bdd.cuke;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Ireth
 *
 */
public class HelloServiceSteps {
	private String outcome = null;
	private HelloService service = new HelloServiceImpl();
	private String userName = null;

	@Given("^User with username (.*)$")
	public void given(String name) throws Throwable {
		this.userName = name;
	}

	@Then("^Greeting message appears$")
	public void then() throws Throwable {
		Assert.assertEquals("Hello, " + this.userName, this.outcome);
	}

	@When("Presses login button$")
	public void when() throws Throwable {
		this.outcome = this.service.sayHello(this.userName);
	}
}
