package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.CrudObject;
import com.smdev.hib.entity.MarkEntity;

/**
 * @author Ireth
 */
public class Mark extends CrudObject<MarkEntity> {

	public Mark(Integer id) throws AppException {
		super(MarkEntity.class, id);
	}

	public Mark(MarkEntity entity) {
		super(entity);
	}

}
