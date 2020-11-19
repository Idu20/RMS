package com.rms.startup.Bean;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerBean {

	String mobileNumber;
	String customerName;
	@JsonFormat(pattern="DD-MM-YYYY")
	Date DOB;
	
	@Override
	public String toString() {
		return "CustomerBean [mobileNumber=" + mobileNumber + ", customerName=" + customerName + ", DOB=" + DOB + "]";
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	
	
	
}
