package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="orderId")
	private String orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="orderdate")
	private Date orderDate;

	@Column(name="orderdiscount")
	private float orderDiscount;

	@Column(name="ordertotal")
	private float orderTotal;

	//bi-directional many-to-one association to Customersitting
	@ManyToOne
	@JoinColumn(name="customersittingid")
	private CustomerSittingEntity customersitting;

	//bi-directional many-to-one association to Ordereditem
	@OneToMany(mappedBy="order")
	private List<OrderedItemsEntity> ordereditems;

	public OrderEntity() {
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

	public CustomerSittingEntity getCustomersitting() {
		return this.customersitting;
	}

	public void setCustomersitting(CustomerSittingEntity customersitting) {
		this.customersitting = customersitting;
	}

	public List<OrderedItemsEntity> getOrdereditems() {
		return this.ordereditems;
	}

	public void setOrdereditems(List<OrderedItemsEntity> ordereditems) {
		this.ordereditems = ordereditems;
	}

	public OrderedItemsEntity addOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().add(ordereditem);
		ordereditem.setOrderEntity(this);

		return ordereditem;
	}

	public OrderedItemsEntity removeOrdereditem(OrderedItemsEntity ordereditem) {
		getOrdereditems().remove(ordereditem);
		ordereditem.setOrderEntity(null);

		return ordereditem;
	}

}