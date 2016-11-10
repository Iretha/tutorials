package com.smdev.hib;

import org.junit.After;
import org.junit.Before;

/**
 * General test which configures hibernate and allows testing CRUD operations with hibernate
 *
 * @author Ireth
 */
public class BaseHibernateTest {

	/** Initialising hibernate configuration */
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

	/**
	 * Closing hibernate factory
	 */
	@After
	public void tearDown() {
		HibernateSessionFactory.getInstance().shutdown();
	}

}
