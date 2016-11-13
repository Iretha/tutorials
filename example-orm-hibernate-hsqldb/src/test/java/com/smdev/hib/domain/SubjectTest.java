package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.entity.SubjectEntity;

/**
 * @author Ireth
 */
public class SubjectTest extends BaseHibernateTest {

	@Test
	public void testCreate() {
		SubjectEntity entity = new SubjectEntity();
		entity.setName("English");

		Subject domain = new Subject(entity);
		try {
			domain.create();
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

}
