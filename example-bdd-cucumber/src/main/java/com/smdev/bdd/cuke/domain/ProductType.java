/**
 *
 */
package com.smdev.bdd.cuke.domain;

/**
 * @author Ireth
 */
public enum ProductType {

	BREAD_MAMAS(0, CategoryType.BREAD, "Mamas bread"),
	BREAD_PAPAS(1, CategoryType.BREAD, "Papas bread"),
	SUGAR_SWEET(2, CategoryType.SUGAR, "Sweet thing");

	private CategoryType category;
	private int code;
	private String name;

	private ProductType(int code, CategoryType category, String name) {
		this.code = code;
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
	 * @return the code
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param productCode
	 * @return
	 */
	public static ProductType findTypeByCode(int productCode) {
		ProductType[] types = ProductType.values();
		for (ProductType t : types) {
			if (t.getCode() == productCode) {
				return t;
			}
		}
		return null;
	}

}
