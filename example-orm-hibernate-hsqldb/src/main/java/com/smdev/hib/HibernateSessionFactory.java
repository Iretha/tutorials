package com.smdev.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Creates Hibernate Session
 *
 * @author Ireth
 */
public class HibernateSessionFactory {

	/** Single instance of the class */
	private static HibernateSessionFactory instance;

	/** @return instance */
	public static HibernateSessionFactory getInstance() {
		if (instance == null) {
			instance = new HibernateSessionFactory();
		}
		return instance;
	}

	/** Hibernate Session Factory */
	private SessionFactory sessionFactory;

	/** Hidden Constructor */
	private HibernateSessionFactory() {
		// prevent instantiating
	}

	/**
	 * @param sessFactory
	 */
	synchronized void initializeFactory(SessionFactory sessFactory) {
		this.sessionFactory = sessFactory;
	}

	/**
	 * @return hibernate session for current user
	 */
	@SuppressWarnings("resource")
	public Session getSession() {
		if (this.sessionFactory == null) {
			throw new RuntimeException("SessionFactory not initialized!");
		}
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}

	/** Closes the session factory */
	public void shutdown() {
		if (this.sessionFactory != null) {
			this.sessionFactory.close();
		}
	}
}
