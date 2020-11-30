package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the waitinglist database table.
 * 
 */
@Entity
@NamedQuery(name="Waitinglist.findAll", query="SELECT w FROM Waitinglist w")
public class Waitinglist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int waitingNumber;

	private int numberOfPerson;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="MobileNumber")
	private Customer customer;

	public Waitinglist() {
	}

	public int getWaitingNumber() {
		return this.waitingNumber;
	}

	public void setWaitingNumber(int waitingNumber) {
		this.waitingNumber = waitingNumber;
	}

	public int getNumberOfPerson() {
		return this.numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}