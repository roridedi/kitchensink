package com.ortech.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Accident.class)
public abstract class Accident_ extends com.ortech.app.model.BaseEntity_ {

	public static volatile SingularAttribute<Accident, AccidentType> accidentType;
	public static volatile SingularAttribute<Accident, Integer> numberOfPassengers;
	public static volatile SingularAttribute<Accident, Boolean> isRaining;

}

