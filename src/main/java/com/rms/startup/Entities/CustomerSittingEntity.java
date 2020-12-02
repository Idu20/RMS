package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="customersitting")
public class CustomerSittingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customersittingid")
	private int customerSittingId;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="mobilenumber")
	private CustomerEntity customer;

	//bi-directional many-to-one association to Restauranttable
	@ManyToOne
	@JoinColumn(name="tableid")
	private RestaurantTableEntity restauranttable;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customersitting")
	private List<OrderEntity> orders;

	public CustomerSittingEntity() {
	}

	public int getCustomerSittingId() {
		return this.customerSittingId;
	}

	public void setCustomerSittingId(int customerSittingId) {
		this.customerSittingId = customerSittingId;
	}

	public CustomerEntity getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public RestaurantTableEntity getRestauranttable() {
		return this.restauranttable;
	}

	public void setRestauranttable(RestaurantTableEntity restauranttable) {
		this.restauranttable = restauranttable;
	}

	public List<OrderEntity> getOrders() {
		return this.orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public OrderEntity addOrder(OrderEntity order) {
		getOrders().add(order);
		order.setCustomersitting(this);

		return order;
	}

	public OrderEntity removeOrder(OrderEntity order) {
		getOrders().remove(order);
		order.setCustomersitting(null);

		return order;
	}

}