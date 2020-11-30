package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ordereditems database table.
 * 
 */
@Embeddable
public class OrdereditemPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable = false, updatable = false)
	private String orderId;

	@Column(insertable = false, updatable = false)
	private int itemId;

	public OrdereditemPK() {
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrdereditemPK)) {
			return false;
		}
		OrdereditemPK castOther = (OrdereditemPK) other;
		return this.orderId.equals(castOther.orderId) && (this.itemId == castOther.itemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId.hashCode();
		hash = hash * prime + this.itemId;

		return hash;
	}
}