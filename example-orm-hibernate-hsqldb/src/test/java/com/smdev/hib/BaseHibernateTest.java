package com.smdev.hib;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

import com.smdev.hib.core.DBEntry;
import com.smdev.hib.core.DomainObject;
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
public abstract class BaseHibernateTest {

	/**
	 * Used for cleaning created objects
	 */
	protected abstract void cleanUp();

	public Course createCourse(Subject subject, CourseDetails details) throws AppException {
		Course domain = new Course(new CourseEntity());
		domain.store(subject, details);
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

	public Student createStudent(String name) throws AppException {
		StudentEntity entity = new StudentEntity();
		entity.setFirstName(name);
		entity.setLastName(name);
		entity.setFacultyNo(name + 123);

		Student domain = new Student(entity);
		domain.store();

		return domain;
	}

	public Subject createSubject(String name) throws AppException {
		SubjectEntity entity = new SubjectEntity();
		entity.setName(name);

		Subject domain = new Subject(entity);
		domain.store();
		return domain;
	}

	public Teacher createTeacher(String firtsLast) throws AppException {
		TeacherEntity entity = new TeacherEntity();
		entity.setFirstName(firtsLast);
		entity.setLastName(firtsLast);

		Teacher domain = new Teacher(entity);
		domain.store();

		return domain;
	}

	public <E extends DBEntry, D extends DomainObject<E>> void delete(D domainObj) {
		if (domainObj != null) {
			try {
				domainObj.delete();
			} catch (AppException e) {
				// already deleted
			}
		}
	}

	/** Initialising hibernate configuration */
	@Before
	public void setUp() {
		JpaFactory.initialize("HSQLDB_persistence");
	}

	/**
	 * Closing hibernate factory
	 */
	@After
	public void tearDown() {
		cleanUp();

		JpaFactory.close(); // writes modified data to the disk
	}

}
