package com.ortech.app.service;

import java.util.List;

import com.ortech.app.model.Insurance;

public interface InsuranceService {

	void saveInsurance(Insurance insurance);

	List<Insurance> getInsurance(Integer id);

	void deleteInsurance(Integer id);

	List<Insurance> updateInsurance(Integer id);

}
