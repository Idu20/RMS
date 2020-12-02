package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;

import com.rms.startup.Bean.CustomerBean;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mobileNumber;

	private String customerName;

	@Temporal(TemporalType.DATE)
	private Date dob;

	//bi-directional many-to-one association to Customersitting
	@OneToMany(mappedBy="customer")
	private List<Customersitting> customersittings;

	//bi-directional many-to-one association to Waitinglist
	@OneToMany(mappedBy="customer")
	private List<Waitinglist> waitinglists;

	public Customer() {
	}

	public Customer(CustomerBean bean) {
		// TODO Auto-generated constructor stub
		this.customerName = bean.getCustomerName();
		this.dob = bean.getDob();
		this.mobileNumber = bean.getMobileNumber();
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Customersitting> getCustomersittings() {
		return this.customersittings;
	}

	public void setCustomersittings(List<Customersitting> customersittings) {
		this.customersittings = customersittings;
	}

	public Customersitting addCustomersitting(Customersitting customersitting) {
		getCustomersittings().add(customersitting);
		customersitting.setCustomer(this);

		return customersitting;
	}

	public Customersitting removeCustomersitting(Customersitting customersitting) {
		getCustomersittings().remove(customersitting);
		customersitting.setCustomer(null);

		return customersitting;
	}

	public List<Waitinglist> getWaitinglists() {
		return this.waitinglists;
	}

	public void setWaitinglists(List<Waitinglist> waitinglists) {
		this.waitinglists = waitinglists;
	}

	public Waitinglist addWaitinglist(Waitinglist waitinglist) {
		getWaitinglists().add(waitinglist);
		waitinglist.setCustomer(this);

		return waitinglist;
	}

	public Waitinglist removeWaitinglist(Waitinglist waitinglist) {
		getWaitinglists().remove(waitinglist);
		waitinglist.setCustomer(null);

		return waitinglist;
	}

	public CustomerBean convertToBean() {
		// TODO Auto-generated method stub
		CustomerBean bean = new CustomerBean();
		bean.setCustomerName(this.getCustomerName());
		bean.setDob(this.getDob());
		bean.setMobileNumber(this.getMobileNumber());
		return bean;
	}

}