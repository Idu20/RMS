package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.DAO.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	public List<CustomerBean> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	public void addCustomer(CustomerBean bean) {
		customerDAO.addCustomer(bean);
	}

	public void deleteCustomer(String mobileNumber)
	{
		customerDAO.deleteCustomer(mobileNumber);
	}
	
	public CustomerBean getCustomer(String mobileNumber)
	{
		return customerDAO.getCustomer(mobileNumber);
	}
	
	public void updateCustomer(String mobileNumber,CustomerBean bean)
	{
		customerDAO.updateCustomer(mobileNumber, bean);
	}
	
}
