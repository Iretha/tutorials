package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class StudentTest extends BaseHibernateTest {
	private Student student = null;

	/* @see com.smdev.hib.BaseHibernateTest#cleanUp() */
	@Override
	protected void cleanUp() {
		delete(this.student);
	}

	@Test
	public void testInsert() {
		try {
			this.student = createStudent("Tom1");
			Assert.assertNotNull(this.student.getId());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
