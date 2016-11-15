package com.smdev.hib;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

import com.smdev.hib.domain.Course;
import com.smdev.hib.domain.CourseDetails;
import com.smdev.hib.domain.Student;
import com.smdev.hib.domain.Subject;
import com.smdev.hib.domain.Teacher;
import com.smdev.hib.entity.CourseDetailsEntity;
import com.smdev.hib.entity.CourseEntity;
import com.smdev.hib.entity.StudentEntity;
import com.smdev.hib.entity.SubjectEntity;
import com.smdev.hib.entity.TeacherEntity;

/**
 * General test which configures hibernate and allows testing CRUD operations with hibernate
 *
 * @author Ireth
 */
public class BaseHibernateTest {

	public Course createCourse() {
		Course domain = new Course(new CourseEntity());
		return domain;
	}

	public CourseDetails createCourseDetails(String code, String name) {
		CourseDetailsEntity cdEntity = new CourseDetailsEntity();
		cdEntity.setCode(code);
		cdEntity.setName(name);
		cdEntity.setStartDate(new Date());

		CourseDetails domain = new CourseDetails(cdEntity);
		return domain;
	}

	public Student createStudent(String first, String last, String facNo) {
		StudentEntity entity = new StudentEntity();
		entity.setFirstName(first);
		entity.setLastName(last);
		entity.setFacultyNo(facNo);

		Student domain = new Student(entity);
		return domain;
	}

	public Subject createSubject(String name) {
		SubjectEntity entity = new SubjectEntity();
		entity.setName(name);

		Subject domain = new Subject(entity);
		return domain;
	}

	public Teacher createTeacher(String first, String last) {
		TeacherEntity entity = new TeacherEntity();
		entity.setFirstName(first);
		entity.setLastName(last);

		Teacher domain = new Teacher(entity);
		return domain;
	}

	/** Initialising hibernate configuration */
	@Before
	public void setUp() {
		JpaFactory.initialize("com.smdev.hib.entity"); // initializes with the proper configuration
	}

	/**
	 * Closing hibernate factory
	 */
	@After
	public void tearDown() {
		JpaFactory.close(); // writes modified data to the disk
	}

}
