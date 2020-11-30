package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customersitting database table.
 * 
 */
@Entity
@NamedQuery(name="Customersitting.findAll", query="SELECT c FROM Customersitting c")
public class Customersitting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int customerSittingId;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="MobileNumber")
	private Customer customer;

	//bi-directional many-to-one association to Restauranttable
	@ManyToOne
	@JoinColumn(name="TableId")
	private Restauranttable restauranttable;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customersitting")
	private List<Order> orders;

	public Customersitting() {
	}

	public int getCustomerSittingId() {
		return this.customerSittingId;
	}

	public void setCustomerSittingId(int customerSittingId) {
		this.customerSittingId = customerSittingId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restauranttable getRestauranttable() {
		return this.restauranttable;
	}

	public void setRestauranttable(Restauranttable restauranttable) {
		this.restauranttable = restauranttable;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomersitting(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomersitting(null);

		return order;
	}

}