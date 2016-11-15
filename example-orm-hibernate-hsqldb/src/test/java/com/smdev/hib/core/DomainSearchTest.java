package com.smdev.hib.core;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.domain.Student;
import com.smdev.hib.entity.StudentEntity;

/**
 * @author Ireth
 */
public class DomainSearchTest extends BaseHibernateTest {

	@Test
	public void testFindAll() {
		try {
			List<Student> students = DomainSearch.findAll(Student.class, StudentEntity.class);
			System.out.println(students.size());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}

	}
}
