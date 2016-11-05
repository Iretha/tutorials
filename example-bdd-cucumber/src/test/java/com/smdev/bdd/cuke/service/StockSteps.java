/**
 * 
 */
package com.smdev.bdd.cuke.service;

import java.util.List;

import org.junit.Assert;

import com.smdev.bdd.cuke.domain.CategoryType;
import com.smdev.bdd.cuke.domain.Product;
import com.smdev.bdd.cuke.domain.ProductType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Scenario steps for feature "Stock management"
 * 
 * @author Ireth
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

	@Then("^in stock are (\\d+) products with product type \"([^\"]*)\"$")
	public void in_stock_are_products_with_product_type_X(int productCount, ProductType type)
			throws Throwable {
		Assert.assertTrue(productCount == this.stock.getAmountByProductType(type));

	}

	@When("^product of type \"([^\"]*)\" is removed$")
	public void product_of_type_X_is_removed(ProductType type) throws Throwable {
		this.stock.removeProduct(type);
	}

	@Then("^in stock are (\\d+) products with category type \"([^\"]*)\"$")
	public void in_stock_are_products_with_category_type_X(int productCount, CategoryType type)
			throws Throwable {
		Assert.assertTrue(productCount == this.stock.getAmountByCategoryType(type));
	}

	@Then("^product with product type \"([^\"]*)\" is in stock$")
	public void product_with_product_type_X_is_in_stock(ProductType type) throws Throwable {
		Assert.assertTrue(this.stock.isInStock(type));
	}

	@Then("^product with product type \"([^\"]*)\" is not in stock$")
	public void product_with_product_type_X_is_not_in_stock(ProductType type) throws Throwable {
		// ProductType type = ProductType.valueOf(productType);
		Assert.assertNotNull(type);
		Assert.assertFalse(this.stock.isInStock(type));
	}

	@When("^product of type \"([^\"]*)\" is removed it should fail with \"([^\"]*)\"$")
	public void product_of_type_X_is_removed_it_should_fail_with(ProductType type, Class<?> excClz)
			throws Throwable {
		try {
			this.stock.removeProduct(type);
			Assert.fail("Expected exception is not thrown!");
		} catch (Exception e) {
			Assert.assertEquals(excClz.getSimpleName(), e.getClass().getSimpleName());
		}
	}

}
