package com.smdev.hib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;

import com.smdev.hib.core.CrudEntity;

/**
 * @author Ireth
 */
@Entity
@DynamicUpdate
@Table(name = "Employee", uniqueConstraints = { @UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL") })
public class EmployeeEntity implements CrudEntity {
	private static final long serialVersionUID = -1798070786993154676L;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;

	public String getEmail() {
		return this.email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setId(Integer employeeId) {
		this.id = employeeId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
