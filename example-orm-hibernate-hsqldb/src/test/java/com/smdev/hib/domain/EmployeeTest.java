package com.smdev.hib.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.entity.EmployeeEntity;

/**
 * @author Ireth
 */
public class EmployeeTest extends BaseHibernateTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * @return
	 */
	private static EmployeeEntity createEntity(String str) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmail(str + "@gmail.com");
		entity.setFirstName("first" + str);
		entity.setLastName("last" + str);
		return entity;
	}

	private Employee employee = null;

	@Override
	@Before
	public void setUp() {
		super.setUp();

		this.employee = new Employee(createEntity("initial"));
		try {
			this.employee.create();
		} catch (AppException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testCreateEmployee() {
		Integer id = this.employee.getId();
		assertNotNull(id);
	}

	@Test
	public void testReadEmployee() {
		try {
			Employee fromDb = new Employee(this.employee.getId());
			assertNotNull(fromDb);
			assertEquals(this.employee.getId(), fromDb.getId());
			assertEquals(this.employee.getEntity().getEmail(), fromDb.getEntity().getEmail());
			assertEquals(this.employee.getEntity().getFirstName(),
					fromDb.getEntity().getFirstName());
			assertEquals(this.employee.getEntity().getLastName(), fromDb.getEntity().getLastName());
		} catch (AppException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testUpdateEmployee() {
		try {
			String str = "aa";

			EmployeeEntity entity = this.employee.getEntity();
			entity.setFirstName(str);
			entity.setEmail(str);
			entity.setLastName(str);
			this.employee.update();

			Employee fromDb = new Employee(this.employee.getId());
			assertNotNull(fromDb);
			assertEquals(this.employee.getId(), fromDb.getId());
			assertEquals(str, fromDb.getEntity().getEmail());
			assertEquals(str, fromDb.getEntity().getFirstName());
			assertEquals(str, fromDb.getEntity().getLastName());
		} catch (AppException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDeleteEmployee() {
		Integer id = this.employee.getId();
		try {
			this.employee.delete();
		} catch (AppException e) {
			fail(e.getMessage());
		}

		try {
			@SuppressWarnings("unused")
			Employee fromDb = new Employee(id);
			this.thrown.expect(AppException.class);
			this.thrown.expectMessage("Entity with ID=" + id + " not found!");
		} catch (AppException e) {
			// expected
		}

	}
}
