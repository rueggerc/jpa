package com.rueggerllc.tests;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
	
	
	// Dummy Reference Data
	private static String[] productIds = 
		{"GT442XHI3", "JT8382X38", "YF662XHI1", "KM3838X37", "LO399FXB2", "877KKJ214",
		 "TR222DG93", "PP8382RW8", "MMN42396B", "WER992162", "EEY828M11", "6677DF122"};
	
	private static String[] regions = 
		{"North America", "South America", "Western Europe", "Eastern Europe", "Asia", "Far East",
		 "Australia", "Scandinavia", "Middle East", "Africa"};
	
	private static String[] notes = 
		{"Business Delivery", "Home Delivery", "Fragile", "Electronics", "Furniture", "Drone", "Repeat Purchase"};
	
	private static int[] status = {100,101,105,108,111,198,202};
	
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
	public void testCreateOrders() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			for (int i = 0; i < 3; i++) {
			CustomerOrder order = new CustomerOrder();
				logger.info("NEXT");
				order.setOrderId(i);
				order.setProductId(getProductId(i));
				order.setCustomerId(getCustomerId());
				order.setQuantity(getQuantity());
				order.setOrderDate(getNowTimestamp());
				order.setRegion(getRegion(i));
				order.setNotes(getNotes(i));
				order.setAmount(getAmount());
				order.setStatus(getStatus());
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
	// @Ignore
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
	private Timestamp getNowTimestamp() {
		Date now = Calendar.getInstance().getTime();
		Timestamp timestamp = new Timestamp(now.getTime());
		return timestamp;
	}
	
	private String getProductId(int i) {
		return productIds[i%productIds.length];
	}
	private int getQuantity() {
		int quantity = (int)(Math.random() * 10) + 1;
		return quantity;
	}
	private String getRegion(int i) {
		return regions[(i+10)%regions.length];
	}
	private String getNotes(int i) {
		return notes[(i+5)%notes.length];
	}
	private int getStatus() {
		int index = (int)(Math.random() * 10) + 1;
		return status[index%status.length]; 
	}
	private BigDecimal getAmount() {
		double amount = (Math.random() * 10000);
		return BigDecimal.valueOf(amount);
	}
	private int getCustomerId() {
		return (int)(Math.random() * 150) + 1;
	}
	
	
}
