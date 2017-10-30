package com.ortech.app.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ortech.app.dao.impl.InsuranceDao;
import com.ortech.app.model.Insurance;

@Stateless
public class InsuranceService {
	
	@Inject
	private InsuranceDao insuranceDao;

	public List<Insurance> findAll(){
		return this.insuranceDao.getAll();
	}
	
	public Insurance findById(Long id){
		return this.insuranceDao.findById(id);
	}
	
	public void save(Insurance insurance) throws Exception{
		this.insuranceDao.save(insurance);
	}
	public void delete(Long id){
		this.insuranceDao.delete(id);
	}
}

