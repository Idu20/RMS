package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the restauranttable database table.
 * 
 */
@Entity
@NamedQuery(name="Restauranttable.findAll", query="SELECT r FROM Restauranttable r")
public class Restauranttable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int tableId;

	private byte occupied;

	private int tableCapacity;

	//bi-directional many-to-one association to Customersitting
	@OneToMany(mappedBy="restauranttable")
	private List<Customersitting> customersittings;

	public Restauranttable() {
	}

	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public byte getOccupied() {
		return this.occupied;
	}

	public void setOccupied(byte occupied) {
		this.occupied = occupied;
	}

	public int getTableCapacity() {
		return this.tableCapacity;
	}

	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}

	public List<Customersitting> getCustomersittings() {
		return this.customersittings;
	}

	public void setCustomersittings(List<Customersitting> customersittings) {
		this.customersittings = customersittings;
	}

	public Customersitting addCustomersitting(Customersitting customersitting) {
		getCustomersittings().add(customersitting);
		customersitting.setRestauranttable(this);

		return customersitting;
	}

	public Customersitting removeCustomersitting(Customersitting customersitting) {
		getCustomersittings().remove(customersitting);
		customersitting.setRestauranttable(null);

		return customersitting;
	}

}