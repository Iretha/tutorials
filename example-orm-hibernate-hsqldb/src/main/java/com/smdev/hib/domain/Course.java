package com.smdev.hib.domain;

import com.smdev.hib.AppException;
import com.smdev.hib.core.DomainObject;
import com.smdev.hib.entity.CourseEntity;

/**
 * @author Ireth
 */
public class Course extends DomainObject<CourseEntity> {

	public Course(CourseEntity entity) {
		super(entity);
	}

	public Course(Integer id) throws AppException {
		super(CourseEntity.class, id);
	}

	/**
	 * Adding a student to the course
	 *
	 * @param student
	 * @throws AppException
	 */
	public void addStudent(Student student) throws AppException {
		getEntity().getStudents().add(student.getEntity());
		super.store();
	}

	/**
	 * Adding teacher to the course
	 *
	 * @param teacher
	 * @throws AppException
	 */
	public void addTeacher(Teacher teacher) throws AppException {
		getEntity().getTeachers().add(teacher.getEntity());
		super.store();
	}

	/**
	 * Removing a student from the course
	 *
	 * @param idx
	 * @throws AppException
	 */
	public void removeStudent(int idx) throws AppException {
		getEntity().getStudents().remove(idx);
		super.store();
	}

	/**
	 * Removes a teacher from the course
	 *
	 * @param idx
	 * @throws AppException
	 */
	public void removeTeacher(int idx) throws AppException {
		getEntity().getTeachers().remove(idx);
		super.store();
	}

	/* @see com.smdev.hib.core.DomainObject#create() */
	public void store(Subject subject, CourseDetails details) throws AppException {
		getEntity().setSubject(subject.getEntity());

		details.store();
		getEntity().setDetails(details.getEntity());

		super.store();
	}
}
