package com.rms.startup.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usertype database table.
 * 
 */
@Entity
@NamedQuery(name="Usertype.findAll", query="SELECT u FROM Usertype u")
public class Usertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userTypeId;

	private String userTypeName;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="usertype")
	private List<User> users;

	public Usertype() {
	}

	public int getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUsertype(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUsertype(null);

		return user;
	}

}