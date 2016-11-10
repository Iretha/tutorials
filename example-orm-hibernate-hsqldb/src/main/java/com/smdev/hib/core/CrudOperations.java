package com.smdev.hib.core;

import com.smdev.hib.AppException;

/**
 * @author Ireth
 */
public interface CrudOperations {

	/**
	 * Inserts entry in DB
	 * 
	 * @return id
	 * @throws AppException
	 */
	Integer create() throws AppException;

	/**
	 * Deletes existing entry from DB
	 *
	 * @throws AppException
	 */
	void delete() throws AppException;

	/**
	 * Reloads existing entry from DB
	 *
	 * @throws AppException
	 */
	void reload() throws AppException;

	/**
	 * Updates existing entry in DB
	 *
	 * @throws AppException
	 */
	void update() throws AppException;
}
