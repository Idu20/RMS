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
	
	public List<UserBean> getAllUser()
	{
		return jdbcTemplate.query("select * from User;", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
}
