package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.core.DomainSearch;
import com.smdev.hib.entity.CourseEntity;
import com.smdev.hib.entity.StudentEntity;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class CourseTest extends BaseHibernateTest {
	@Test
	public void testAddTeacher() {
		try {
			Teacher teacher = DomainSearch.findById(Teacher.class, TeacherEntity.class, 2);

			Course course = DomainSearch.findById(Course.class, CourseEntity.class, 7);
			course.addTeacher(teacher);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSignup() {
		try {
			Student student = DomainSearch.findById(Student.class, StudentEntity.class, 4);

			Course course = DomainSearch.findById(Course.class, CourseEntity.class, 7);
			course.signup(student);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testStore() {
		Subject subject = createSubject("EN");
		CourseDetails details = createCourseDetails("EN_A1", "English Lvl A1");
		Course domain = createCourse();
		try {
			domain.store(subject, details);
			System.out.println(domain);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
