package com.smdev.hib.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smdev.hib.AppException;
import com.smdev.hib.HibernateSessionFactory;
import com.smdev.hib.util.HibernateUtil;

/**
 * Services for retrieving entries from DB.
 *
 * @author Ireth
 */
public class DomainSearch {

	/**
	 * Lists all entries from DB
	 *
	 * @throws AppException
	 */
	public static <E extends DBEntry, D extends DomainObject<E>> List<D> findAll(
			Class<D> domainClz, Class<E> enityClz, Integer id) throws AppException {
		D domainObject = null;
		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		List<D> found = new ArrayList<>();
		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(enityClz);
			Root<E> eRoot = criteria.from(enityClz);
			criteria.select(eRoot);

			List<E> list = HibernateUtil.getEntityManager().createQuery(criteria).getResultList();
			Constructor<D> constr = domainClz.getConstructor(enityClz);
			for (E entity : list) {
				domainObject = constr.newInstance(entity);
				found.add(domainObject);
			}

			tx.commit();
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
		return found;
	}

	/**
	 * Look for an entry by it's PK in DB
	 *
	 * @throws AppException
	 */
	public static <E extends DBEntry, D extends DomainObject<E>> D findById(Class<D> domainClz,
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

	/**
	 * Look for an entry by it's PK in DB
	 *
	 * @throws AppException
	 */
	public static <E extends DBEntry, D extends DomainObject<E>> D findLast(Class<D> domainClz,
			Class<E> enityClz) throws AppException {
		// TODO refactor -> select only last
		D domainObject = null;
		try {

			CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(enityClz);

			Root<E> eRoot = criteria.from(enityClz);
			criteria.select(eRoot);

			List<E> list = HibernateUtil.getEntityManager().createQuery(criteria).getResultList();
			Constructor<D> constr = domainClz.getConstructor(enityClz);
			for (E entity : list) {
				domainObject = constr.newInstance(entity);
			}

		} catch (Exception e) {
			throw new AppException(e);
		}
		return domainObject;
	}
}
