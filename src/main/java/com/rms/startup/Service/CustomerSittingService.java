package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.CustomerSittingBean;
import com.rms.startup.DAO.CustomerSittingDAO;

@Service
public class CustomerSittingService {

	@Autowired
	CustomerSittingDAO customerSittingDAO;

	public List<CustomerSittingBean> getAllCustomerSittings() {
		return customerSittingDAO.getAllCustomerSittings();
	}
	
	
	public String addCustomerSitting(CustomerSittingBean customerSitting){
		if(customerSittingDAO.getCustomerSitting(customerSitting.getCustomerSittingId()) == null)
		{
			customerSittingDAO.addCustomerSitting(customerSitting);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateCustomerSitting(CustomerSittingBean customerSitting){
		if(customerSittingDAO.getCustomerSitting(customerSitting.getCustomerSittingId()) != null)
		{
			customerSittingDAO.updateCustomerSitting(customerSitting);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteCustomerSitting(Integer customerSittingId){
		if(customerSittingDAO.getCustomerSitting(customerSittingId) != null)
		{
			try{
				customerSittingDAO.deleteCustomerSitting(customerSittingId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public CustomerSittingBean getCustomerSitting(Integer customerSittingId)
	{
		return customerSittingDAO.getCustomerSitting(customerSittingId);
	}
	
	public Integer findByTableId(Integer tableId)
	{
		return customerSittingDAO.findByTableId(tableId);
	}
	
}