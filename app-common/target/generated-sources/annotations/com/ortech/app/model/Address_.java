package com.ortech.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ extends com.ortech.app.model.BaseEntity_ {

	public static volatile SingularAttribute<Address, String> zip;
	public static volatile SingularAttribute<Address, String> streetName;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> houseNumber;
	public static volatile SingularAttribute<Address, String> state;
	public static volatile SingularAttribute<Address, HomeType> homeType;
	public static volatile SingularAttribute<Address, String> streetEnding;

}

