package com.rueggerllc.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class ThreadTests {

	private static Logger logger = Logger.getLogger(ThreadTests.class);

	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Dummy Test");
	}
	
	@Test
	// @Ignore
	public void testProducerThread() {
		try {
			Runnable runnable = () -> {
			    try {
			    	OrderProducer orderProducer = new OrderProducer();
			    	for (int i = 0; i < 10; i++) {
				        String name = Thread.currentThread().getName();
				        System.out.println("Thread Running: " + name);
				        orderProducer.execute(1);
				        TimeUnit.SECONDS.sleep(62);
			    	}
			    }
			    catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			};

			Thread thread = new Thread(runnable);
			thread.start();
			
			// Wait until Done
			logger.info("Main Thread Waiting...");
			thread.join();
			logger.info("==== DONE====");
			
		} catch (Exception e) {
			logger.error("ERROR", e);
		}		
	}
	
	@Test
	@Ignore
	public void testProducerExecutor() {
		try {
		} catch (Exception e) {
			logger.error("ERROR", e);
		}		
	}
	

	
}
