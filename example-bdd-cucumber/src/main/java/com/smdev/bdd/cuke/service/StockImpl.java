/**
 *
 */
package com.smdev.bdd.cuke.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smdev.bdd.cuke.domain.CategoryType;
import com.smdev.bdd.cuke.domain.Product;
import com.smdev.bdd.cuke.domain.ProductType;

/**
 * @author Ireth
 */
public class StockImpl {

	/** Stock */
	private Map<CategoryType, Map<ProductType, List<Product>>> stock = new HashMap<>();

	/**
	 * @param category
	 *            - category type
	 * @return map of products with key - product type
	 */
	private Map<ProductType, List<Product>> getProductsByCategory(CategoryType category) {
		if (!this.stock.containsKey(category)) {
			this.stock.put(category, new HashMap<>());
		}
		return this.stock.get(category);
	}

	/**
	 * @param productType
	 *            - product type
	 * @return - list of products
	 */
	private List<Product> getProductsByType(ProductType productType) {
		Map<ProductType, List<Product>> products = getProductsByCategory(productType.getCategory());
		if (!products.containsKey(productType)) {
			products.put(productType, new ArrayList<>());
		}
		return products.get(productType);
	}

	/**
	 * Adds a product to stock
	 *
	 * @param product
	 * @return true/false
	 */
	public boolean addProduct(Product product) {
		List<Product> prods = getProductsByType(product.getType());
		return prods.add(product);
	}

	/**
	 * @param category
	 * @return the amount of products of the same category
	 */
	public int getAmountByCategoryType(CategoryType category) {
		Map<ProductType, List<Product>> prods = getProductsByCategory(category);
		int amount = prods.values().stream().mapToInt(v -> v.size()).sum();
		return amount;
	}

	/**
	 * @param productType
	 * @return the amount of products of the same product type
	 */
	public int getAmountByProductType(ProductType productType) {
		List<Product> prods = getProductsByType(productType);
		return prods.size();
	}

	/**
	 * Checks if the product is available in stock
	 *
	 * @param productType
	 * @return true/false
	 */
	public boolean isInStock(ProductType productType) {
		return getAmountByProductType(productType) != 0;
	}

	/**
	 * Removes a product
	 *
	 * @param productType
	 * @return true/false
	 */
	public void removeProduct(ProductType productType) throws StockException {
		List<Product> prods = getProductsByType(productType);
		if (prods.isEmpty() || prods.remove(prods.size() - 1) == null) {
			throw new StockException("Product is not available!");
		}
	}

}
