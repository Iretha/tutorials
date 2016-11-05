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

	@Given("^User with username '(.*)$'")
	public void givenWithUsername(String name) throws Throwable {
		this.userName = name;
	}

	@Then("^Greeting message with text '(.*)' appears$")
	public void thenGreetingMsgAppears(String greeting) throws Throwable {
		Assert.assertEquals(greeting, this.outcome);
	}

	@When("Presses login button$")
	public void whenLoginBtnIsPessed() throws Throwable {
		this.outcome = this.service.sayHello(this.userName);
	}
}
