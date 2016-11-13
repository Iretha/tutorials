package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.entity.StudentEntity;

/**
 * @author Ireth
 */
public class StudentTest extends BaseHibernateTest {
	@Test
	public void testCreate() {
		StudentEntity entity = new StudentEntity();
		entity.setFirstName("Tom");
		entity.setLastName("Miller");
		entity.setFacultyNo("123TomMiller");

		Student domain = new Student(entity);
		try {
			domain.create();
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
