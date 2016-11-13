package com.smdev.hib.domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.smdev.hib.AppException;
import com.smdev.hib.BaseHibernateTest;
import com.smdev.hib.entity.CourseDetailsEntity;
import com.smdev.hib.entity.CourseEntity;
import com.smdev.hib.entity.SubjectEntity;

/**
 * @author Ireth
 */
public class CourseTest extends BaseHibernateTest {
	@Test
	public void testCreate() {
		CourseDetailsEntity cdEntity = new CourseDetailsEntity();
		cdEntity.setCode("EN_A1");
		cdEntity.setName("English Lvl A1");
		cdEntity.setStartDate(new Date());

		SubjectEntity sEntity = new SubjectEntity();
		sEntity.setName("EN_A1");

		Course domain = new Course(new CourseEntity());
		try {
			domain.create(new Subject(sEntity), new CourseDetails(cdEntity));
		} catch (AppException e) {
			Assert.fail(e.getMessage());
		}
	}
}
