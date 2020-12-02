package com.rms.startup.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="ordereditems")
public class OrderedItemsEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ordereditemsid")
	private Integer orderedItemsId;
	
	@Column(name="instruction")
	private String instruction;

	@Column(name="quantity")
	private int quantity;

	@Column(name="status")
	private int status;

	@ManyToOne
	@JoinColumn(name="itemid")
	private ItemEntity item;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderid")
	private OrderEntity order;
	

	public OrderedItemsEntity() {
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
	
	public void setItemEntity(ItemEntity item)
	{
		this.item = item;
	}
	public ItemEntity getItemEntity()
	{
		return item;
	}
	public void setOrderEntity(OrderEntity order)
	{
		this.order = order;
	}
	public OrderEntity getOrderEntity()
	{
		return order;
	}

}
