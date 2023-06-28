package org.hibernate.bugs;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestTbl.class)
public abstract class TestTbl_ {

	public static volatile SingularAttribute<TestTbl, Long> jobId;
	public static volatile SingularAttribute<TestTbl, Long> id;

	public static final String JOB_ID = "jobId";
	public static final String ID = "id";

}

