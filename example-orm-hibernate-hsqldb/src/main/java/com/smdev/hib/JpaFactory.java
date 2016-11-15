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

	/** Single instance of the class */
	private static JpaFactory instance;

	/** @return instance */
	private static JpaFactory getInstance() {
		if (instance == null) {
			instance = new JpaFactory();
		}
		return instance;
	}

	/** @return CriteriaBuilder */
	public static CriteriaBuilder getCriteriaBuilder() {
		return getInstance().getEmFactory().getCriteriaBuilder();
	}

	/** @return EntityManager */
	public static EntityManager getEntityManager() {
		return getInstance().getEmFactory().createEntityManager();
	}

	private final EntityManagerFactory emFactory;

	/** Hidden constructor */
	private JpaFactory() {
		super();
		this.emFactory = Persistence.createEntityManagerFactory("com.smdev.hib.entity");
	}

	/** @return the emFactory */
	private EntityManagerFactory getEmFactory() {
		return this.emFactory;
	}
}
