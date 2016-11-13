package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.core.DomainSearch;
import com.smdev.hib.entity.CourseEntity;
import com.smdev.hib.entity.MarkEntity;
import com.smdev.hib.entity.StudentEntity;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class MarkTest extends BaseHibernateTest {

	@Test
	public void testCreate() {
		try {

			DomainSearch.findById(Course.class, CourseEntity.class, 1);
			DomainSearch.findById(Student.class, StudentEntity.class, 1);
			DomainSearch.findById(Teacher.class, TeacherEntity.class, 1);

			MarkEntity entity = new MarkEntity();

			// TODO
			Mark domain = new Mark(entity);
			domain.create();
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
