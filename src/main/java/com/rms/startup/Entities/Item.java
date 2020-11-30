package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemId;

	private String itemDescription;

	private String itemName;

	private float itemPrice;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="ItemCategoryId")
	private Category category;

	//bi-directional many-to-one association to Ordereditem
	@OneToMany(mappedBy="item")
	private List<Ordereditem> ordereditems;

	public Item() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Ordereditem> getOrdereditems() {
		return this.ordereditems;
	}

	public void setOrdereditems(List<Ordereditem> ordereditems) {
		this.ordereditems = ordereditems;
	}

	public Ordereditem addOrdereditem(Ordereditem ordereditem) {
		getOrdereditems().add(ordereditem);
		ordereditem.setItem(this);

		return ordereditem;
	}

	public Ordereditem removeOrdereditem(Ordereditem ordereditem) {
		getOrdereditems().remove(ordereditem);
		ordereditem.setItem(null);

		return ordereditem;
	}

}