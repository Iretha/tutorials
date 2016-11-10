package com.smdev.hib;

import org.junit.After;
import org.junit.Before;

/**
 * @author Ireth
 */
public class BaseHibernateTest {

	@Before
	public void setUp() {
		HibernateConfigurationFactory hibConfig = new HibernateConfigurationFactory(
				"/hibernate.cfg.xml", "/hibernate.classes.properties");
		try {
			hibConfig.initialize();
		} catch (AppException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		HibernateSessionFactory.getInstance().shutdown();
	}

}
