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
	private int id;
	private ProductType type;

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return this.type;
	}

}
