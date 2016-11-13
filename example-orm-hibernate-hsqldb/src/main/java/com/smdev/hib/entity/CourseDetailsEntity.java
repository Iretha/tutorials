package com.smdev.hib.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.smdev.hib.core.DBEntity;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "courses_details", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "code") })
public class CourseDetailsEntity implements DBEntity {

	/** */
	private static final long serialVersionUID = 7970852029306729778L;

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

}
