package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class StudentTest extends BaseHibernateTest {
	@Test
	public void testStore() {
		Student domain = createStudent("Tom1", "Miller1", "123Tom1Miller1");
		try {
			domain.store();
			System.out.println(domain);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
