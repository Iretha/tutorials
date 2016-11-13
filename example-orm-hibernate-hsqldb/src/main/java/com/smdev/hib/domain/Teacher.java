package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.DomainObject;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class Teacher extends DomainObject<TeacherEntity> {

	public Teacher(Integer id) throws AppException {
		super(TeacherEntity.class, id);
	}

	public Teacher(TeacherEntity entity) {
		super(entity);
	}

	/* @see com.smdev.hib.core.CrudObject#create() */
	@Override
	public Integer create() throws AppException {
		return super.create();
	}

}
