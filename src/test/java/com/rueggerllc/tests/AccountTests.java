package com.rueggerllc.tests;

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

public class AccountTests {

	private static Logger logger = Logger.getLogger(AccountTests.class);
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
	@Ignore
	public void testCreateAccounts() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			for (int i = 0; i < 10; i++) {
				Account account = new Account();
				account.setName("Account" + i);
				account.setAddress("100 Main Street");
				account.setState("Virginia");
				account.setZip("20171");
				account.setCreateDate(getNow());
				account.setStatus(100+i);
				em.persist(account);
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
	// @Ignore
	public void testGetAllAccounts() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Account> query = em.createNamedQuery("account.findAll", Account.class);
			List<Account> accounts = query.getResultList();
			for (Account account : accounts) {
				logger.info("Account=" + account.getName());
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
