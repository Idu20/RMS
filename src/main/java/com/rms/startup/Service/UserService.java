package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Bean.UserBean;
import com.rms.startup.DAO.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public List<UserBean> getAllUser() {
		return userDAO.getAllUser();
	}

	public void addUser(UserBean bean) {
		if(userDAO.getUser(bean.getMobileNumber()) == null)
			userDAO.addUser(bean);
	}

	public boolean deleteUser(String mobileNumber)
	{
		if(userDAO.getUser(mobileNumber) != null)
		{
			userDAO.deleteUser(mobileNumber);
			return true;
		}
		return false;
	}
	
	public UserBean getUser(String mobileNumber)
	{
		if(userDAO.getUser(mobileNumber) != null)
			return userDAO.getUser(mobileNumber);
		return null;
	}
	
	public void updateUser(UserBean bean)
	{
		if(userDAO.getUser(bean.getMobileNumber()) != null)
			userDAO.updateUser(bean);
	}
	
	public boolean validateUser(String mobileNumber,String password)
	{
		if(userDAO.getUser(mobileNumber).getPassword().equals(password))
			return true;
		else
			return false;
	}
}
