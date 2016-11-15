package com.smdev.hib.domain;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.core.DomainSearch;
import com.smdev.hib.entity.TeacherEntity;

/**
 * @author Ireth
 */
public class TeacherTest extends BaseHibernateTest {

	private Teacher teacher = null;

	/* @see com.smdev.hib.BaseHibernateTest#cleanUp() */
	@Override
	protected void cleanUp() {
		delete(this.teacher);
	}

	@Test
	public void testDelete() {
		try {
			Teacher t1 = createTeacher("Example");
			t1.delete();

			Assert.assertNull(
					DomainSearch.findById(Teacher.class, TeacherEntity.class, t1.getId()));
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			this.teacher = createTeacher("Franco");
			Assert.assertNotNull(this.teacher.getId());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testReload() {
		try {
			this.teacher = createTeacher("Example");
			this.teacher.getEntity().setFirstName("Updated");
			this.teacher.reload();

			Assert.assertSame("Example", this.teacher.getEntity().getFirstName());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testUpdate() {
		try {
			this.teacher = createTeacher("Example");
			this.teacher.getEntity().setFirstName("Updated");
			this.teacher.store();

			this.teacher = DomainSearch.findById(Teacher.class, TeacherEntity.class,
					this.teacher.getId());
			Assert.assertSame("Updated", this.teacher.getEntity().getFirstName());
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
