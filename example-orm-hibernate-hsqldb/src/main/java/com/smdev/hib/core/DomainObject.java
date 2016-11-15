package com.smdev.hib.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.smdev.hib.AppException;
import com.smdev.hib.JpaFactory;

/**
 * Represents a Domain Object with it's base CRUD operations.
 *
 * @author Ireth
 */
public abstract class DomainObject<Entity extends DBEntry> {

	/** List of fields to be skipped in toString() */
	private static final List<String> SKIP_FIELDS = new ArrayList<>(
			Arrays.asList("serialVersionUID"));

	/** Hibernate entity */
	private Entity entity;

	/**
	 * @param clz
	 * @param id
	 * @throws AppException
	 */
	public DomainObject(Class<?> clz, Integer id) throws AppException {
		super();
		load(clz, id);
	}

	/**
	 * @param entity
	 */
	public DomainObject(Entity entity) {
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

		EntityManager em = JpaFactory.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			this.entity = (Entity) em.find(clz, id);
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
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	/**
	 * Inserts entry in DB
	 *
	 * @return id
	 * @throws AppException
	 */
	protected void insert() throws AppException {
		EntityManager em = JpaFactory.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(getEntity());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new AppException(e);
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	protected void store() throws AppException {
		if (getEntity().getId() == null) {
			insert();
		} else {
			update();
		}
	}

	/**
	 * Deletes existing entry from DB
	 *
	 * @throws AppException
	 */
	public void delete() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		EntityManager em = JpaFactory.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(getEntity());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new AppException(e);
		} finally {
			if (em.isOpen()) {
				em.close();
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

	/**
	 * Reloads existing entry from DB
	 *
	 * @throws AppException
	 */
	public void reload() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		load(getEntity().getClass(), getEntity().getId());
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[").append(this.entity.getClass().getSimpleName()).append(":");
		Field[] fields = null;
		Object fieldValue = null;
		String fName = null;
		for (Class<?> clz = this.entity.getClass(); clz != null; clz = clz.getSuperclass()) {
			fields = clz.getDeclaredFields();
			for (Field field : fields) {
				fName = field.getName();
				if (!SKIP_FIELDS.contains(fName)) {
					field.setAccessible(true);
					try {
						fieldValue = field.get(this.entity);
						b.append(" ").append(fName).append("=").append(fieldValue).append(";");
					} catch (Exception e) {
						// not important here
					}
				}
			}
		}
		return b.append("]").toString();
	}

	/**
	 * Updates existing entry in DB
	 *
	 * @throws AppException
	 */
	public void update() throws AppException {
		if (getEntity().getId() == null) {
			throw new AppException("Entity not persisted!");
		}

		EntityManager em = JpaFactory.getEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(getEntity());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new AppException(e);
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

}
