package com.rueggerllc.tests;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Account;
import com.rueggerllc.beans.CustomerOrder;

public class CustomerOrderTests {

	private static Logger logger = Logger.getLogger(CustomerOrderTests.class);
	private EntityManager em = null;
	
	
	@BeforeClass
	public static void setupClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setupTest() throws Exception {
	}

	@After
	public void tearDownTest() throws Exception {
	}
	
	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Dummy Test");
	}
	
	@Test
	// @Ignore
	public void testCreateOrders() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			for (int i = 0; i < 10; i++) {
			CustomerOrder order = new CustomerOrder();
				order.setOrderId(42L);
				order.setProductId("GT442XHI3");
				order.setCustomerId(311);
				order.setQuantity(3);
				order.setOrderDate(getNow());
				order.setRegion("North America");
				order.setNotes("These are the notes");
				order.setAmount(BigDecimal.valueOf(178.92));
				order.setStatus(100);
				em.persist(order);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("ERROR", e);
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}		
	}
	
	@Test
	@Ignore
	public void testGetAllOrders() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CustomerOrder> query = em.createNamedQuery("customerOrder.findAll", CustomerOrder.class);
			List<CustomerOrder> orders = query.getResultList();
			for (CustomerOrder order : orders) {
				logger.info("Order=\n" + order);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			logger.error("ERROR", e);
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
	
	
	private Date getNow() {
		Date now = Calendar.getInstance().getTime();
		return now;
	}
	

	
	
}
