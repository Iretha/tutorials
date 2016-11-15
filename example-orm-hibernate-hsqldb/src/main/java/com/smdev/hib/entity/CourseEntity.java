package com.smdev.hib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.smdev.hib.core.DBEntry;

/**
 * @author Ireth
 */

@Entity
@DynamicUpdate
@Table(name = "courses", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class CourseEntity implements DBEntry {

	/** */
	private static final long serialVersionUID = -8686776524391627300L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "details_ID", unique = true, nullable = false)
	private CourseDetailsEntity details;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	/* I use "FetchType.EAGER" because lists will be small (not more than 50 entries). If you expect
	 * a big amount of entries, better emulate the relationship with two bidirectional one-to-many
	 * associations and manipulate the relationship from the "ManyToOne" side. */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "courses_students", uniqueConstraints = @UniqueConstraint(columnNames = {
			"course_ID", "student_ID" }), joinColumns = {
					@JoinColumn(name = "course_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
							@JoinColumn(name = "student_ID", nullable = false, updatable = false) })
	private List<StudentEntity> students;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_ID", unique = false, nullable = false)
	private SubjectEntity subject;

	/* I use "FetchType.EAGER" because lists will be small (not more than 50 entries). If you expect
	 * a big amount of entries, better emulate the relationship with two bidirectional one-to-many
	 * associations and manipulate the relationship from the "ManyToOne" side. */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "courses_teachers", uniqueConstraints = @UniqueConstraint(columnNames = {
			"course_ID", "teacher_ID" }), joinColumns = {
					@JoinColumn(name = "course_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
							@JoinColumn(name = "teacher_ID", nullable = false, updatable = false) })
	private List<TeacherEntity> teachers;

	/**
	 * @return the details
	 */
	public CourseDetailsEntity getDetails() {
		return this.details;
	}

	/**
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the students
	 */
	public List<StudentEntity> getStudents() {
		return this.students;
	}

	/**
	 * @return the subject
	 */
	public SubjectEntity getSubject() {
		return this.subject;
	}

	/**
	 * @return the teachers
	 */
	public List<TeacherEntity> getTeachers() {
		return this.teachers;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(CourseDetailsEntity details) {
		this.details = details;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	/**
	 * @param teachers
	 *            the teachers to set
	 */
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

}
