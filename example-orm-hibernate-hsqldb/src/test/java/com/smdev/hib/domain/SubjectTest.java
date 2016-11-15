package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class SubjectTest extends BaseHibernateTest {

	@Test
	public void testStore() {
		Subject domain = createSubject("English");
		try {
			domain.store();
			System.out.println(domain);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

}
