package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;

/**
 * @author Ireth
 */
public class CourseTest extends BaseHibernateTest {

	private Course course = null;
	private Student student = null;
	private Subject subject1 = null;
	private Subject subject2 = null;
	private Teacher teacher = null;

	/* @see com.smdev.hib.BaseHibernateTest#cleanUp() */
	@Override
	protected void cleanUp() {
		delete(this.course);
		delete(this.subject1);
		delete(this.subject2);
		delete(this.student);
		delete(this.teacher);
	}

	@Test
	public void testAddStudent() {
		try {
			this.subject1 = createSubject("EN");
			this.course = createCourse(this.subject1, "English Lvl A1");

			this.student = createStudent("student1");
			this.course.addStudent(this.student);

			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getStudents().size() == 1);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testAddTeacher() {
		try {
			this.subject1 = createSubject("EN");
			this.course = createCourse(this.subject1, "English Lvl A1");

			this.teacher = createTeacher("teacher");
			this.course.addTeacher(this.teacher);

			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getTeachers().size() == 1);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testChangeSubject() {
		try {
			this.subject1 = createSubject("EN1");
			this.course = createCourse(this.subject1, "English Lvl A1");
			Assert.assertSame("EN1", this.course.getEntity().getSubject().getName());

			this.subject2 = createSubject("EN2");
			this.course.changeSubject(this.subject2);

			this.course = new Course(this.course.getId()); // reaload from db
			Assert.assertSame("EN2", this.course.getEntity().getSubject().getName());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			this.subject1 = createSubject("EN");
			this.course = createCourse(this.subject1, "English Lvl A1");
			Assert.assertNotNull(this.course.getId());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveStudent() {
		try {
			this.subject1 = createSubject("EN");
			this.course = createCourse(this.subject1, "English Lvl A1");

			this.student = createStudent("student1");
			this.course.addStudent(this.student);

			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getStudents().size() == 1);

			this.course.removeStudent(0);
			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getStudents().size() == 0);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveTeacher() {
		try {
			this.subject1 = createSubject("EN");
			this.course = createCourse(this.subject1, "English Lvl A1");

			this.teacher = createTeacher("teacher");
			this.course.addTeacher(this.teacher);

			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getTeachers().size() == 1);

			this.course.removeTeacher(0);
			this.course = new Course(this.course.getId()); // reload from db
			Assert.assertTrue(this.course.getEntity().getTeachers().size() == 0);
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

}
