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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.smdev.hib.core.DBEntry;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "teachers", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class TeacherEntity implements DBEntry {

	/** */
	private static final long serialVersionUID = -6563708678295022431L;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "courses_teachers", joinColumns = {
			@JoinColumn(name = "course_ID", nullable = true, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "teacher_ID", nullable = true, updatable = true) })
	private List<CourseEntity> courses;

	@Column(name = "first_name", unique = false, nullable = false, length = 100)
	private String firstName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "last_name", unique = false, nullable = false, length = 100)
	private String lastName;

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
