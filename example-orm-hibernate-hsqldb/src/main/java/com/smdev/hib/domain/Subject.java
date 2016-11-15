package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.DomainObject;
import com.smdev.hib.entity.SubjectEntity;

/**
 * @author Ireth
 */
public class Subject extends DomainObject<SubjectEntity> {

	public Subject(Integer id) throws AppException {
		super(SubjectEntity.class, id);
	}

	public Subject(SubjectEntity entity) {
		super(entity);
	}

	/* @see com.smdev.hib.core.CrudObject#create() */
	@Override
	public void store() throws AppException {
		super.store();
	}

}
