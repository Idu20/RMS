package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.UserBean;
import com.rms.startup.DAO.JPA.UserRepository;
import com.rms.startup.Entities.User;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	UserRepository repo;

	public List<UserBean> getAllUser() {
		List<User> lst = repo.findAll();
		List<UserBean> returnLst = new ArrayList<UserBean>();
		for (User list : lst)
			returnLst.add(list.convertToBean());
		return returnLst;
	}

	public void addUser(UserBean bean) {
		User u = new User(bean);
		repo.save(u);
	}

	public void deleteUser(String mobileNumber) {
		// jdbcTemplate.update("delete from user where MobileNumber=?", mobileNumber);
	}

	public UserBean getUser(String mobileNumber) {
		return repo.findById(mobileNumber).get().convertToBean();
	}

	public void updateUser(String mobileNumber, UserBean bean) {
		// jdbcTemplate.update("update User set MobileNumber=?,password=?,UserType=?
		// where MobileNumber=?",
		// bean.getMobileNumber(), bean.getPassword(), bean.getUserType(),
		// mobileNumber);
	}

}
