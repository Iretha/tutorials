package com.smdev.hib.core;

import java.lang.reflect.Constructor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smdev.hib.AppException;
import com.smdev.hib.HibernateSessionFactory;

/**
 * Services for retrieving entries from DB.
 * 
 * @author Ireth
 */
public class DomainSearch {

	/**
	 * Look for an entry by it's PK in DB
	 *
	 * @throws AppException
	 */
	public static <E extends DBEntity, D extends DomainObject<E>> D findById(Class<D> domainClz,
			Class<E> enityClz, Integer id) throws AppException {

		D domainObject = null;
		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			E entity = session.find(enityClz, id);
			tx.commit();

			if (entity != null) {
				Constructor<D> constr = domainClz.getConstructor(enityClz);
				domainObject = constr.newInstance(entity);
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new AppException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return domainObject;
	}
}
