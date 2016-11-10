package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.EmployeeEntity;

/**
 * @author Ireth
 */
public class Employee extends CrudObject<EmployeeEntity> {

	/**
	 * @param entity
	 */
	public Employee(EmployeeEntity entity) {
		super(entity);
	}

	/**
	 * @param id
	 * @throws AppException
	 */
	public Employee(Integer id) throws AppException {
		super(EmployeeEntity.class, id);
	}

}
