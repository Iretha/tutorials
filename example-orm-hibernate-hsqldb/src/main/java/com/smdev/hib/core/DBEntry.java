package com.smdev.hib.core;

import java.io.Serializable;

/**
 * Represents an entity with an ID column.
 *
 * @author Ireth
 */
public interface DBEntry extends Serializable {
	/** @return unique identifier */
	Integer getId();

	/**
	 * @param id
	 */
	void setId(Integer id);
}
