package com.ortech.app.model;

import javax.persistence.Entity;

@Entity
public class Insurance extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InsuranceType insuranceType;
	private Double deductibleAmount;

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Double getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(Double deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceType=" + insuranceType + ", deductibleAmount=" + deductibleAmount + "]";
	}

}
