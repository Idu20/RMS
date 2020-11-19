package com.rms.startup.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CustomerBean;

@Repository
public class CustomerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<CustomerBean> getAllCustomers() {
		return jdbcTemplate.query("select * from customer;", new BeanPropertyRowMapper<>(CustomerBean.class));
	}

	public void addCustomer(CustomerBean bean) {
		jdbcTemplate.update("insert into customer(MobileNumber,customerName,DOB) values(?,?,?)",bean.getMobileNumber(), bean.getCustomerName(),
				bean.getDOB());
	}
	
	public void deleteCustomer(String mobileNumber)
	{
		jdbcTemplate.update("delete from customer where MobileNumber=?",mobileNumber);
	}
	
	public CustomerBean getCustomer(String mobileNumber)
	{
		return jdbcTemplate.queryForObject("select * from customer where mobileNumber=?",new BeanPropertyRowMapper<>(CustomerBean.class),mobileNumber);
	}
}
