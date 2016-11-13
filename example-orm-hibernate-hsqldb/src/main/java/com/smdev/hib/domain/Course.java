package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.CourseEntity;

/**
 * @author Ireth
 */
public class Course extends CrudObject<CourseEntity> {

	public Course(CourseEntity entity) {
		super(entity);
	}

	public Course(Integer id) throws AppException {
		super(CourseEntity.class, id);
	}

	/* @see com.smdev.hib.core.CrudObject#create() */
	public Integer create(Subject subject, CourseDetails details) throws AppException {
		subject.create();
		details.create();

		getEntity().setSubject(subject.getEntity());
		getEntity().setDetails(details.getEntity());

		return super.create();
	}
}
