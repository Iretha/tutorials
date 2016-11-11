package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class Teacher extends CrudObject<TeacherEntity> {

	public Teacher(Integer id) throws AppException {
		super(TeacherEntity.class, id);
	}

	public Teacher(TeacherEntity entity) {
		super(entity);
	}

}
