package com.rueggerllc.tests;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.rueggerllc.beans.CustomerOrder;

public class OrderProducer {
	
	private static Logger logger = Logger.getLogger(OrderProducer.class);
	private EntityManager em = null;
	
	public OrderProducer() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
		em = emf.createEntityManager();	
	}
	
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
	
	public void execute(int numberOfOrders) {
		try {
			// EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");
			// em = emf.createEntityManager();
			em.getTransaction().begin();
			for (int i = 0; i < numberOfOrders; i++) {
				int seed = (int)(Math.random() * 100) + 1;
				CustomerOrder order = new CustomerOrder();
				order.setOrderId(seed);
				order.setProductId(getProductId(seed));
				order.setCustomerId(getCustomerId());
				order.setQuantity(getQuantity());
				order.setOrderDate(getNow());
				order.setRegion(getRegion(seed));
				order.setNotes(getNotes(seed));
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
	
	private Date getNow() {
		Date now = Calendar.getInstance().getTime();
		return now;
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
