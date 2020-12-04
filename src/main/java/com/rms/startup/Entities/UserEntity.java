package com.rms.startup.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.rms.startup.Bean.UserBean;
import com.rms.startup.Bean.UserTypeBean;

@Entity
@Table(name="user")
public class UserEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4990248415284750718L;

	@Id
	@Column(name = "mobilenumber")
	private String mobileNumber;
	
	@Column(name="password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "usertype")
	private UserTypeEntity userType;

	public UserEntity() {
	}

	public UserEntity(UserBean u) {
		this.mobileNumber = u.getMobileNumber();
		this.password = u.getPassword();
		this.userType = new UserTypeEntity(u.getUserType());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserBean convertToBean() {
		UserBean u = new UserBean();
		u.setMobileNumber(this.mobileNumber);
		u.setPassword(this.password);
		u.setUserType(this.userType);
		return u;
	}

}
