package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.SubjectEntity;

/**
 * @author Ireth
 */
public class Subject extends CrudObject<SubjectEntity> {

	public Subject(Integer id) throws AppException {
		super(SubjectEntity.class, id);
	}

	public Subject(SubjectEntity entity) {
		super(entity);
	}

}
