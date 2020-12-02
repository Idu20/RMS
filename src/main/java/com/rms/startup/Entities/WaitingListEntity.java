package com.rms.startup.Entities;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the waitinglist database table.
 * 
 */
@Entity
@Table(name="waitinglist")
public class WaitingListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="waitingnumber")
	private int waitingNumber;

	@Column(name="numberofperson")
	private int numberOfPerson;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="mobilenumber")
	private CustomerEntity customer;

	public WaitingListEntity() {
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

	public CustomerEntity getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

}
