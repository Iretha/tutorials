package com.smdev.hib.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Ireth
 */
public class HibernateUtil {
	// TODO refactor
	private static final EntityManagerFactory emFactory;
	static {
		emFactory = Persistence.createEntityManagerFactory("com.smdev.hib.entity");
	}

	public static CriteriaBuilder getCriteriaBuilder() {
		CriteriaBuilder builder = emFactory.getCriteriaBuilder();
		return builder;
	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
}
