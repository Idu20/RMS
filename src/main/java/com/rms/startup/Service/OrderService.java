package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.OrderBean;
import com.rms.startup.DAO.OrderDAO;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;

	public List<OrderBean> getAllOrders() {
		return orderDAO.getAllOrders();
	}
	
	
	public String addOrder(OrderBean order){
		if(orderDAO.getOrder(order.getOrderId()) == null)
		{
			orderDAO.addOrder(order);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateOrder(OrderBean order){
		if(orderDAO.getOrder(order.getOrderId()) != null)
		{
			orderDAO.updateOrder(order);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteOrder(String orderId){
		if(orderDAO.getOrder(orderId) != null)
		{
			try{
				orderDAO.deleteOrder(orderId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public OrderBean getOrder(String orderId)
	{
		return orderDAO.getOrder(orderId);
	}
	
	public String findByCustomerSittingId(Integer customerSittingId)
	{
		return orderDAO.findByCustomerSittingId(customerSittingId);
	}
	
	
}