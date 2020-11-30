package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String orderId;

	@Temporal(TemporalType.DATE)
	private Date orderDate;

	private float orderDiscount;

	private float orderTotal;

	//bi-directional many-to-one association to Customersitting
	@ManyToOne
	@JoinColumn(name="CustomerSittingId")
	private Customersitting customersitting;

	//bi-directional many-to-one association to Ordereditem
	@OneToMany(mappedBy="order")
	private List<Ordereditem> ordereditems;

	public Order() {
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderDiscount() {
		return this.orderDiscount;
	}

	public void setOrderDiscount(float orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public float getOrderTotal() {
		return this.orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Customersitting getCustomersitting() {
		return this.customersitting;
	}

	public void setCustomersitting(Customersitting customersitting) {
		this.customersitting = customersitting;
	}

	public List<Ordereditem> getOrdereditems() {
		return this.ordereditems;
	}

	public void setOrdereditems(List<Ordereditem> ordereditems) {
		this.ordereditems = ordereditems;
	}

	public Ordereditem addOrdereditem(Ordereditem ordereditem) {
		getOrdereditems().add(ordereditem);
		ordereditem.setOrder(this);

		return ordereditem;
	}

	public Ordereditem removeOrdereditem(Ordereditem ordereditem) {
		getOrdereditems().remove(ordereditem);
		ordereditem.setOrder(null);

		return ordereditem;
	}

}