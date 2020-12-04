package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.UserBean;
import com.rms.startup.DAO.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;

	public List<UserBean> getAllUser() {
		return userDAO.getAllUser();
	}

	public String addUser(UserBean bean) {
		if (userDAO.getUser(bean.getMobileNumber()) == null) {
			userDAO.addUser(bean);
			return Messages.added;
		}
		return Messages.notAdded;

	}

	public String deleteUser(String mobileNumber) {
		if (userDAO.getUser(mobileNumber) != null) {
			userDAO.deleteUser(mobileNumber);
			return Messages.deleted;
		}
		return Messages.notDeleted;
	}

	public UserBean getUser(String mobileNumber) {
		if (userDAO.getUser(mobileNumber) != null)
			return userDAO.getUser(mobileNumber);
		return null;
	}

	public String updateUser(String mobileNumber,UserBean bean) {
		if (userDAO.getUser(mobileNumber) != null)
		{
			userDAO.updateUser(bean);
			return Messages.updated;
		}
		return Messages.notUpdated;
			
	}

	public boolean validateUser(UserBean bean) {
		if (userDAO.getUser(bean.getMobileNumber()).getPassword().equals(bean.getPassword()))
			return true;
		else
			return false;
	}
}
