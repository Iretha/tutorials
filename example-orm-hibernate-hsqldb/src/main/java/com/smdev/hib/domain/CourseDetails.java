package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.DomainObject;
import com.smdev.hib.entity.CourseDetailsEntity;

/**
 * @author Ireth
 */
public class CourseDetails extends DomainObject<CourseDetailsEntity> {

	public CourseDetails(CourseDetailsEntity entity) {
		super(entity);
	}

	public CourseDetails(Integer id) throws AppException {
		super(CourseDetailsEntity.class, id);
	}

	/* @see com.smdev.hib.core.CrudObject#create() */
	@Override
	public void store() throws AppException {
		super.store();
	}
}
