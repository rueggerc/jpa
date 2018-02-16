package com.rueggerllc.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="customer_order")
@NamedQueries
({
	@NamedQuery(name="customerOrder.findAll",query="select o from CustomerOrder o"),
	@NamedQuery(name="customerOrder.findByRegion",query="select o from CustomerOrder o where o.region=:region")
})
public class CustomerOrder {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private long id;
	
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="product_id")
	private String productId;
	
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="quantity")
	private long quantity;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="region")
	private String region;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="status")
	private long status;
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerOrder.id: " + id);
		builder.append("\nCustomerOrder.orderId: " + orderId);
		builder.append("\nCustomerOrder.productId: " + productId);
		builder.append("\nCustomerOrder.customerId: " + customerId);
		builder.append("\nCustomerOrder.quantity: " + quantity);
		builder.append("\nCustomerOrder.orderDate: " + orderDate);
		builder.append("\nCustomerOrder.region: " + region);
		builder.append("\nCustomerOrder.notes: " + notes);
		builder.append("\nCustomerOrder.amount: " + amount);
		builder.append("\nCustomerOrder.status: " + status);
		return builder.toString();
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}



	public long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}



	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
	



}
