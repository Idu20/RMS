package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ordereditems database table.
 * 
 */
@Entity
@Table(name="ordereditems")
@NamedQuery(name="Ordereditem.findAll", query="SELECT o FROM Ordereditem o")
public class Ordereditem implements Serializable {
	private static final long serialVersionUID = 1L;


	private String instruction;

	private int quantity;

	private int status;

	//bi-directional many-to-one association to Item
	@Id
	@ManyToOne
	@JoinColumn(name="itemId")
	private Item item;

	//bi-directional many-to-one association to Order
	@Id
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	public Ordereditem() {
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}