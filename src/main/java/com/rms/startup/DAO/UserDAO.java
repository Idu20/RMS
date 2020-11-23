package com.rms.startup.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.UserBean;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<UserBean> getAllUser() {
		return jdbcTemplate.query("select * from User;", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void addUser(UserBean bean) {
		jdbcTemplate.update("insert into User(MobileNumber,password,UserType) values(?,?,?)", bean.getMobileNumber(),
				bean.getPassword(), bean.getUserType());
	}

	public void deleteUser(String mobileNumber) {
		jdbcTemplate.update("delete from user where MobileNumber=?", mobileNumber);
	}

	public UserBean getUser(String mobileNumber) {
		return jdbcTemplate.queryForObject("select * from User where mobileNumber=?", new BeanPropertyRowMapper<>(UserBean.class), mobileNumber);
	}

	public void updateUser(String mobileNumber, UserBean bean) {
		jdbcTemplate.update("update User set MobileNumber=?,password=?,UserType=? where MobileNumber=?",
				bean.getMobileNumber(), bean.getPassword(), bean.getUserType(), mobileNumber);
	}

}
