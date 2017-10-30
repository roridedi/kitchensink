package com.ortech.app.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;

import com.ortech.app.model.Insurance;

public class InsuranceDao extends GenericDaoImpl<Insurance> {

	@Inject
	private Logger logger;

	public Insurance findById(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("Insurance ID can not be null");
		}
		Insurance insurance = null;
		EntityManager em = this.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Insurance> insuranceQ = cb.createQuery(Insurance.class);
		Root<Insurance> iRoot = insuranceQ.from(Insurance.class);

		insuranceQ.select(iRoot);
		insuranceQ.where(cb.equal(iRoot.get("id"), id));
		Insurance insruance = em.createQuery(insuranceQ).getSingleResult();

		return insruance;
	}

	@Override
	public Insurance save(Insurance insurance) throws Exception {

		return super.save(insurance);
	}
}
