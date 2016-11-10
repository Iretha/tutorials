package com.smdev.hib.core;

import java.io.Serializable;

/**
 * @author Ireth
 */
public interface CrudEntity extends Serializable {
	/** @return unique identifier */
	Integer getId();

	/**
	 * @param id
	 */
	void setId(Integer id);
}
