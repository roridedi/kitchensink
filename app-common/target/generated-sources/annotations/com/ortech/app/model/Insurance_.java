package com.ortech.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Insurance.class)
public abstract class Insurance_ extends com.ortech.app.model.BaseEntity_ {

	public static volatile SingularAttribute<Insurance, Double> deductibleAmount;
	public static volatile SingularAttribute<Insurance, InsuranceType> insuranceType;

}

