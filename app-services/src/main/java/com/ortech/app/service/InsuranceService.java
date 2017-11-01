package com.ortech.app.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ortech.app.dao.InsuranceDao;
import com.ortech.app.model.Insurance;

@Stateless
public class InsuranceService implements GenericService<Insurance> {

	@Inject
	private InsuranceDao insuranceDao;

	@Override
	public Serializable save(Insurance insurance) {
		return insuranceDao.save(insurance);
	}

	@Override
	public void saveOrUpdate(Insurance insurance) {
		insuranceDao.saveOrUpdate(insurance);

	}

	@Override
	public void delete(Insurance insurance) {
		insuranceDao.delete(insurance);

	}

	@Override
	public void deleteAll() {
		insuranceDao.deleteAll();

	}

	@Override
	public List<Insurance> findAll() {
		return insuranceDao.findAll();
	}

	@Override
	public List<Insurance> findAllByExample(Insurance insurance) {

		return insuranceDao.findAllByExample(insurance);
	}

	@Override
	public Insurance findById(Serializable id) {
		// TODO Auto-generated method stub
		return insuranceDao.findById(id);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

}
