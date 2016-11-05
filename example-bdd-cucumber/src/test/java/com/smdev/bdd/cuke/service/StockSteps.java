/**
 * 
 */
package com.smdev.bdd.cuke.service;

import java.util.List;

import org.junit.Assert;

import com.smdev.bdd.cuke.domain.Product;
import com.smdev.bdd.cuke.domain.ProductType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Ireth
 *
 */
public class StockSteps {

	private StockImpl stock = new StockImpl();

	@Given("^stock is initialized with the following products$")
	public void stock_is_initialized_with_the_following_products(List<Product> initial)
			throws Throwable {
		for (Product p : initial) {
			this.stock.addProduct(p);
		}
	}

	@When("^products with following data are added to stock$")
	public void products_with_following_data_are_added_to_stock(List<Product> newProducts)
			throws Throwable {
		for (Product p : newProducts) {
			this.stock.addProduct(p);
		}
	}

	@Then("^in stock are (\\d+) products with product type (.*)$")
	public void in_stock_are_products_with_product_type_X(int productCount, String productType)
			throws Throwable {
		ProductType type = ProductType.valueOf(productType);
		Assert.assertNotNull(type);
		Assert.assertTrue(productCount == this.stock.getAmountByProductType(type));

	}

	@When("^product of type (.*) is removed$")
	public void product_of_type_X_is_removed(String productCode) throws Throwable {
		ProductType type = ProductType.valueOf(productCode);
		this.stock.removeProduct(type);
	}
}
