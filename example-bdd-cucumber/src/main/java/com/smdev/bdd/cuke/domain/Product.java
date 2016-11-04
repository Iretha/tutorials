/**
 *
 */
package com.smdev.bdd.cuke.domain;

import java.util.Date;

/**
 * @author Ireth
 *
 */
public class Product {

	private Date expiryDate;
	private ProductType type;

	public Product(ProductType type, Date expiryDate) {
		super();
		this.type = type;
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return this.type;
	}

}
