package com.smdev.hib.core;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.smdev.hib.AppException;
import com.smdev.hib.HibernateSessionFactory;

/**
 * @author Ireth
 */
public abstract class CrudObject<Entity extends CrudEntity> implements CrudOperations {

	/** Hibernate entity */
	private Entity entity;

	/**
	 * @param clz
	 * @param id
	 * @throws AppException
	 */
	public CrudObject(Class<?> clz, Integer id) throws AppException {
		super();
		load(clz, id);
	}

	/**
	 * @param entity
	 */
	public CrudObject(Entity entity) {
		super();
		this.entity = entity;
	}

	/**
	 * Loads entry from DB by Class and ID
	 *
	 * @param clz
	 * @param id
	 * @throws AppException
	 */
	@SuppressWarnings("unchecked")
	private void load(Class<?> clz, Integer id) throws AppException {
		if (id == null) {
			throw new AppException("Entity ID missing!");
		}

		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			this.entity = (Entity) session.find(clz, id);
			if (this.entity == null) {
				throw new AppException("Entity with ID=" + id + " not found!");
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
	}

	/* @see com.smdev.hib.domain.CRUD#create() */
	@Override
	public Integer create() throws AppException {
		Integer id = null;
		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			id = (Integer) session.save(getEntity());
			tx.commit();

			getEntity().setId(id); // not to reload the entity
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
		return id;
	}

	/* @see com.smdev.hib.domain.CRUD#delete() */
	@Override
	public void delete() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(getEntity());
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
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return this.entity;
	}

	/** @return id */
	public Integer getId() {
		return getEntity().getId();
	}

	/* @see com.smdev.hib.domain.CRUD#read() */
	@Override
	public void reload() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		load(getEntity().getClass(), getEntity().getId());
	}

	/* @see com.smdev.hib.domain.CRUD#update() */
	@Override
	public void update() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		Session session = HibernateSessionFactory.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(getEntity());
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
	}

}
