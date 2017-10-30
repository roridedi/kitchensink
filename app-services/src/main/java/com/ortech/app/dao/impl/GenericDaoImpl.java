package com.ortech.app.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import com.ortech.app.dao.GenericDao;
import com.ortech.app.model.BaseEntity;

/**
 * Implementation of Generic DAO. *
 * 
 * @param <T>
 *            Entity type for DOA, Must extend CharaEntity
 */
@Stateless
public class GenericDaoImpl<T extends BaseEntity> implements GenericDao<T> {

	/**
	 * Logger.
	 */
	@Inject
	private Logger logger;

	/**
	 * Entity Manager.
	 */
	@Inject
	private EntityManager entityManager;

	/**
	 * Entity Class.
	 */
	private final Class<T> entityClass;

	/**
	 * Default Constructor.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		final ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEntityManager(final EntityManager newEntityManager) {
		this.entityManager = newEntityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(final Long id) {
		final T entity = this.entityManager.find(this.entityClass, id);
		if (entity == null) {
			throw new NoResultException(
					"Entity Type: " + this.entityClass.getName() + " with ID: " + id + " Not Found.");
		}

		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> get(final Long... ids) {
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("ID List must not be null and have atleast one element");
		}

		final List<T> entityList = new ArrayList<T>(ids.length);
		for (final Long id : ids) {
			final T entity = this.get(id);
			entityList.add(entity);
		}
		return entityList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> getAll() {
		final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
		final Root<T> root = criteriaQuery.from(this.entityClass);
		criteriaQuery.select(root);

		final TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	public T save(final T object) throws Exception {
		T savedObject = null;

		// This is an Update
		if (object.getId() != null) {
			this.logger.debug("Save is an UPDATE not an INSERT");

			// Get existing Object from DB
			T foundObject = this.entityManager.find(this.entityClass, object.getId());

			// Merge with Existing Object
			if (foundObject != null) {
				this.logger.debug(
						"Merging Object with Type: " + this.entityClass.getName() + " with ID " + object.getId());

				// Save it
				this.entityManager.merge(foundObject);
				this.entityManager.flush();
				savedObject = foundObject;

				this.logger.debug(
						"Completed Object Merge: " + this.entityClass.getName() + " with ID " + savedObject.getId());

				return savedObject;
			} else {
				throw new NoResultException(this.entityClass.getName() + " with ID " + object.getId() + " Not Found");
			}
		}

		// Its a Save if we made it this far
		this.logger.debug("Persisting Object " + this.entityClass.getName());
		this.entityManager.persist(object);
		this.entityManager.flush();

		savedObject = object;

		this.logger.debug("Persisted with ID " + savedObject.getId());

		return savedObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception
	 */
	@Override
	public List<T> save(final T... objects) throws Exception {
		if (objects == null || objects.length == 0) {
			throw new IllegalArgumentException("Object List must not be null and have atleast one element");
		}

		final List<T> entityList = new ArrayList<T>(objects.length);
		for (final T entity : objects) {
			final T savedEntity = this.save(entity);

			// Flush the persistence context to force validation
			this.entityManager.flush();

			entityList.add(savedEntity);
		}
		return entityList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Long id) {
		final T entity = this.get(id);
		this.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final Long... ids) {
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("Object List must not be null and have atleast one element");
		}

		for (final Long id : ids) {
			this.delete(id);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final T object) {
		this.entityManager.remove(object);
		this.logger.debug("Deleting Object " + this.entityClass.getName() + " with ID " + object.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final T... objects) {
		if (objects == null || objects.length == 0) {
			throw new IllegalArgumentException("Object List must not be null and have atleast one element");
		}

		for (final T entity : objects) {
			this.delete(entity);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		final List<T> entities = this.getAll();
		for (final T entity : entities) {
			this.delete(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findByExample(final T example) {
		final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

		// Build the Query
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.entityClass);
		final Root<T> root = criteriaQuery.from(this.entityClass);

		// Select all Columns
		criteriaQuery.select(root);

		// Build Where Clause
		Predicate predicate = criteriaBuilder.conjunction();
		final Field[] fields = this.entityClass.getDeclaredFields();
		for (final Field field : fields) {
			final String fieldName = field.getName();

			// So that we ignore fields that we know cause problems
			if (fieldName.startsWith("$") || fieldName.equalsIgnoreCase("serialVersionUID")) {
				continue;
			}

			Object fieldValue = null;

			try {
				AccessController.doPrivileged(new PrivilegedAction<Object>() {
					public Object run() {
						field.setAccessible(true);
						return null;
					}
				});
				fieldValue = field.get(example);
			} catch (final IllegalArgumentException e) {
				this.logger.warn("findByExample Skipping Field " + fieldName + " on Object Type "
						+ this.entityClass.getName() + ".", e);
				continue;
			} catch (final IllegalAccessException e) {
				this.logger.warn("findByExample Skipping Field " + fieldName + " on Object Type "
						+ this.entityClass.getName() + ".", e);
				continue;
			}

			if (fieldValue != null) {
				this.logger.debug("Setting Where: " + fieldName + " = " + fieldValue.toString());
				predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(fieldName), fieldValue));
			}
		}

		criteriaQuery.where(predicate);
		final TypedQuery<T> query = this.entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}