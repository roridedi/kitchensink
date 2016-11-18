package com.ortech.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ extends com.ortech.app.model.BaseEntity_ {

	public static volatile SingularAttribute<Customer, Boolean> isMarried;
	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile ListAttribute<Customer, Car> car;
	public static volatile ListAttribute<Customer, Accident> accident;

}

