package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.UserBean;
import com.rms.startup.DAO.JPA.UserRepository;
import com.rms.startup.Entities.UserEntity;

@Repository
@Transactional
public class UserDAO {

	@Autowired
	UserRepository repo;

	public List<UserBean> getAllUser() {
		List<UserEntity> lst = repo.findAll();
		List<UserBean> returnLst = new ArrayList<UserBean>();
		for(UserEntity list : lst)
			returnLst.add(list.convertToBean());
		return returnLst;
	}

	public void addUser(UserBean bean) {
		UserEntity u = new UserEntity(bean);
		repo.save(u);
	}

	public void deleteUser(String mobileNumber) {
		//jdbcTemplate.update("delete from user where MobileNumber=?", mobileNumber);
	}

	public UserBean getUser(String mobileNumber) {
		try
		{
			return repo.findById(mobileNumber).get().convertToBean();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public void updateUser(String mobileNumber, UserBean bean) {
		//jdbcTemplate.update("update User set MobileNumber=?,password=?,UserType=? where MobileNumber=?",
			//	bean.getMobileNumber(), bean.getPassword(), bean.getUserType(), mobileNumber);
	}

}
