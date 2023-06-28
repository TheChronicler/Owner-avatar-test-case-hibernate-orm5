package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();


		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestTbl> criteriaQuery = criteriaBuilder.createQuery(TestTbl.class);
		Root<TestTbl> root = criteriaQuery.from(TestTbl.class);

		CriteriaQuery<TestDto> queryMulti = criteriaBuilder.createQuery(TestDto.class);
		queryMulti.getRoots().add(root);

		CriteriaQuery<?> multiselect = queryMulti.multiselect(root.get(TestTbl_.id));

		TypedQuery<TestDto> query = (TypedQuery<TestDto>) entityManager.createQuery(multiselect);
		List<TestDto> resultListIds = query.getResultList();

		// Do stuff...
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
