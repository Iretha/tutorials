package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.DomainObject;
import com.smdev.hib.entity.StudentEntity;

/**
 * @author Ireth
 */
public class Student extends DomainObject<StudentEntity> {

	public Student(Integer id) throws AppException {
		super(StudentEntity.class, id);
	}

	public Student(StudentEntity entity) {
		super(entity);
	}

	/* @see com.smdev.hib.core.CrudObject#create() */
	@Override
	public Integer create() throws AppException {
		return super.create();
	}

}
