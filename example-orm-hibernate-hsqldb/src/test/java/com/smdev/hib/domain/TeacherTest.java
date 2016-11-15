package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class TeacherTest extends BaseHibernateTest {

	@Test
	public void testStore() {
		Teacher domain = createTeacher("Franco4", "Brown4");
		try {
			domain.store();
			System.out.println(domain);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
