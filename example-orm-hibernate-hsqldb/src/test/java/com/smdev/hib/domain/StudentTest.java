package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.core.DomainSearch;
import com.smdev.hib.entity.StudentEntity;

/**
 * @author Ireth
 */
public class StudentTest extends BaseHibernateTest {
	private Student student = null;

	/* @see com.smdev.hib.BaseHibernateTest#cleanUp() */
	@Override
	protected void cleanUp() {
		delete(this.student);
	}

	@Test
	public void testDelete() {
		try {
			Student t1 = createStudent("Example");
			t1.delete();

			Assert.assertNull(
					DomainSearch.findById(Student.class, StudentEntity.class, t1.getId()));
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			this.student = createStudent("Tom1");
			Assert.assertNotNull(this.student.getId());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testReload() {
		try {
			this.student = createStudent("Example");
			this.student.getEntity().setFirstName("Updated");
			this.student.reload();

			Assert.assertSame("Example", this.student.getEntity().getFirstName());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testUpdate() {
		try {
			this.student = createStudent("Example");
			this.student.getEntity().setFirstName("Updated");
			this.student.store();

			this.student = DomainSearch.findById(Student.class, StudentEntity.class,
					this.student.getId());
			Assert.assertSame("Updated", this.student.getEntity().getFirstName());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
