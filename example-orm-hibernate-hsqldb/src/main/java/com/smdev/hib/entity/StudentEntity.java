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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

import com.smdev.hib.core.CrudEntity;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "students", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class StudentEntity implements CrudEntity {

	/** */
	private static final long serialVersionUID = 9115140792403717766L;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "courses_students", joinColumns = {
			@JoinColumn(name = "course_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "student_ID", nullable = false, updatable = false) })
	private List<CourseEntity> courses;

	@Column(name = "faculty_no", unique = true, nullable = false, length = 20)
	private String facultyNo;

	@Column(name = "first_name", unique = false, nullable = false, length = 100)
	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "last_name", unique = false, nullable = false, length = 100)
	private String lastName;

	/**
	 * @return the courses
	 */
	public List<CourseEntity> getCourses() {
		return this.courses;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param courses
	 *            the courses to set
	 */
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
