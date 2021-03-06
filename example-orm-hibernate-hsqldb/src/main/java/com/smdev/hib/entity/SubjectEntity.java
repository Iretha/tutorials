package com.smdev.hib.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

import com.smdev.hib.core.DBEntry;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "subjects", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "name") })
public class SubjectEntity implements DBEntry {

	/** */
	private static final long serialVersionUID = 258750302448670999L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", orphanRemoval = true)
	private List<CourseEntity> courses;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", unique = true, nullable = false, length = 100)
	private String name;

	/**
	 * @return the courses
	 */
	public List<CourseEntity> getCourses() {
		return this.courses;
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
	 * @param courses
	 *            the courses to set
	 */
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
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

}
