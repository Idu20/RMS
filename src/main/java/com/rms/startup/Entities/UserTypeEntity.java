package com.rms.startup.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rms.startup.Bean.UserTypeBean;

@Entity
@Table(name="usertype")
public class UserTypeEntity {
	@Id
	@Column(name="usertypeid")
	private int userTypeId;
	
	@Column(name="usertypename")
	private String userTypeName;
	
	
	public UserTypeEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserTypeEntity(UserTypeBean bean)
	{
		
	}
	
	
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
}
