package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class TeacherTest extends BaseHibernateTest {

	@Test
	public void testCreate() {
		TeacherEntity entity = new TeacherEntity();
		entity.setFirstName("Franco");
		entity.setLastName("Brown");

		Teacher domain = new Teacher(entity);
		try {
			domain.create();
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
