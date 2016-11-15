package com.smdev.hib;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Singleton class that can't be instantiated directly or extended. It holds a single instance of
 * the EntityManagerFactory, that serves the entire application.
 *
 * @author Ireth
 */
public final class JpaFactory {

	/** Single instance of EntityManagerFactory */
	private static EntityManagerFactory emFactory;

	/** Single instance of the class */
	private static JpaFactory instance;

	/** @return instance */
	private static JpaFactory getInstance() {
		if (instance == null) {
			instance = new JpaFactory();
		}
		return instance;
	}

	/**
	 * Closes the factory in order to HSQLDB to be persisted on the disk. Once closed, factory
	 * should be re-initialised for further usage.
	 */
	public static void close() {
		if (getInstance().getEmFactory().isOpen()) {
			getInstance().getEmFactory().close();
		}
		emFactory = null;
	}

	/** @return CriteriaBuilder */
	public static CriteriaBuilder getCriteriaBuilder() {
		return getInstance().getEmFactory().getCriteriaBuilder();
	}

	/** @return EntityManager */
	public static EntityManager getEntityManager() {
		return getInstance().getEmFactory().createEntityManager();
	}

	public static void initialize(String persistenceName) {
		if (emFactory != null) {
			throw new RuntimeException("JpaFactory already initialized!");
		}
		emFactory = Persistence.createEntityManagerFactory(persistenceName);
	}

	/** Hidden constructor */
	private JpaFactory() {
		super();
	}

	/** @return the emFactory */
	private EntityManagerFactory getEmFactory() {
		if (emFactory == null) {
			throw new RuntimeException("JpaFactory not initialized!");
		}
		return emFactory;
	}
}
