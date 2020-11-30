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

	@EmbeddedId
	private OrdereditemPK id;

	private String instruction;

	private int quantity;

	private int status;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="ItemId")
	private Item item;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Order order;

	public Ordereditem() {
	}

	public OrdereditemPK getId() {
		return this.id;
	}

	public void setId(OrdereditemPK id) {
		this.id = id;
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