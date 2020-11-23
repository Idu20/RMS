package com.rms.startup.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.Bean.UserBean;
import com.rms.startup.Service.CustomerService;

@RequestMapping("/customer")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/show")
	public List<CustomerBean> showData()
	{
		return customerService.getAllCustomer();
	}

	@PostMapping("/add")
	public void addCustomer(@RequestBody CustomerBean bean)
	{
		customerService.addCustomer(bean);
	}
	
	@GetMapping("/show/{mobileNumber}")
	public CustomerBean getCustomer(@PathVariable String mobileNumber)
	{
		return customerService.getCustomer(mobileNumber);
	}
	
	@DeleteMapping("/delete/{mobileNumber}")
	public void deleteCustomer(@PathVariable String mobileNumber)
	{
		customerService.deleteCustomer(mobileNumber);
	}
	
	@PutMapping("/update/{mobileNumber}")
	public void updateCustomer(@RequestBody CustomerBean bean,@PathVariable String mobileNumber)
	{
		customerService.updateCustomer(mobileNumber, bean);
	}
	
}