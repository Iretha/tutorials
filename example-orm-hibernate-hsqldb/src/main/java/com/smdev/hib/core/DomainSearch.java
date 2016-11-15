package com.smdev.hib.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.smdev.hib.AppException;
import com.smdev.hib.JpaFactory;

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
	public static <E extends DBEntry, D extends DomainObject<E>> List<D> findAll(Class<D> domainClz,
			Class<E> enityClz) throws AppException {
		D domainObject = null;
		List<D> found = new ArrayList<>();
		try {
			CriteriaBuilder builder = JpaFactory.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(enityClz);
			Root<E> eRoot = criteria.from(enityClz);
			criteria.select(eRoot);

			List<E> list = JpaFactory.getEntityManager().createQuery(criteria).getResultList();
			Constructor<D> constr = domainClz.getConstructor(enityClz);
			for (E entity : list) {
				domainObject = constr.newInstance(entity);
				found.add(domainObject);
			}
		} catch (Exception e) {
			throw new AppException(e);
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
		EntityManager em = JpaFactory.getEntityManager();
		try {
			E entity = em.find(enityClz, id);
			if (entity != null) {
				Constructor<D> constr = domainClz.getConstructor(enityClz);
				domainObject = constr.newInstance(entity);
			}
		} catch (Exception e) {
			throw new AppException(e);
		} finally {
			if (em.isOpen()) {
				em.close();
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

			CriteriaBuilder builder = JpaFactory.getCriteriaBuilder();
			CriteriaQuery<E> criteria = builder.createQuery(enityClz);

			Root<E> eRoot = criteria.from(enityClz);
			criteria.select(eRoot);

			List<E> list = JpaFactory.getEntityManager().createQuery(criteria).getResultList();
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
