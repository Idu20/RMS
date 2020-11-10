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
	
	public List<UserBean> getAllUser()
	{
		return userDAO.getAllUser();
	}
	
}
