/**
 *
 */
package com.smdev.bdd.cuke.example;

/**
 * @author Ireth
 */
public enum ProductType {

	BREAD_MAMAS(CategoryType.BREAD, "Mamas bread"),
	BREAD_PAPAS(CategoryType.BREAD, "Papas bread"),
	SUGAR_SWEET(CategoryType.SUGAR, "Sweet thing");

	private CategoryType category;
	private String name;

	private ProductType(CategoryType category, String name) {
		this.category = category;
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public CategoryType getCategory() {
		return this.category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
