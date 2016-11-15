package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class SubjectTest extends BaseHibernateTest {

	private Subject subject = null;

	/* @see com.smdev.hib.BaseHibernateTest#cleanUp() */
	@Override
	protected void cleanUp() {
		delete(this.subject);
	}

	@Test
	public void testInsert() {
		try {
			this.subject = createSubject("English");
			Assert.assertNotNull(this.subject.getId());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

}
