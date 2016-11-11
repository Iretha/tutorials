package com.smdev.hib.entity;

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.smdev.hib.core.CrudEntity;

/**
 * @author Ireth
 */

@Entity
@DynamicUpdate
@Table(name = "courses", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "code") })
public class CourseEntity implements CrudEntity {

	/** */
	private static final long serialVersionUID = -8686776524391627300L;

	@Column(name = "code", unique = true, nullable = false, length = 100)
	private String code;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false, length = 100)
	private String name;

	@Column(name = "start_date", unique = false, nullable = true)
	@Type(type = "date")
	private Date startDate;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "courses_students", joinColumns = {
			@JoinColumn(name = "course_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "student_ID", nullable = false, updatable = false) })
	private List<StudentEntity> students;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_ID", unique = false, nullable = false)
	private SubjectEntity subject;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "courses_teachers", joinColumns = {
			@JoinColumn(name = "course_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "teacher_ID", nullable = false, updatable = false) })
	private List<TeacherEntity> teachers;

	/**
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return this.startDate;
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
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	 * @return the teachers
	 */
	public List<TeacherEntity> getTeachers() {
		return this.teachers;
	}

	/**
	 * @param teachers
	 *            the teachers to set
	 */
	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

}
