package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.CourseDetailsEntity;

/**
 * @author Ireth
 */
public class CourseDetails extends CrudObject<CourseDetailsEntity> {

	public CourseDetails(CourseDetailsEntity entity) {
		super(entity);
	}

	public CourseDetails(Integer id) throws AppException {
		super(CourseDetailsEntity.class, id);
	}

}
