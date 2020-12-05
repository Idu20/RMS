package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.OrderedItemsBean;
import com.rms.startup.DAO.OrderedItemsDAO;

@Service
public class OrderedItemsService {

	@Autowired
	OrderedItemsDAO orderedItemsDAO;

	public List<OrderedItemsBean> getAllOrderedItemss() {
		return orderedItemsDAO.getAllOrderedItemss();
	}
	
	
	public String addOrderedItems(OrderedItemsBean orderedItems){
		if(orderedItemsDAO.getOrderedItems(orderedItems.getOrderedItemsId()) == null)
		{
			orderedItemsDAO.addOrderedItems(orderedItems);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateOrderedItems(OrderedItemsBean orderedItems){
		if(orderedItemsDAO.getOrderedItems(orderedItems.getOrderedItemsId()) != null)
		{
			orderedItemsDAO.updateOrderedItems(orderedItems);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteOrderedItems(Integer orderedItemsId){
		if(orderedItemsDAO.getOrderedItems(orderedItemsId) != null)
		{
			try{
				orderedItemsDAO.deleteOrderedItems(orderedItemsId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public OrderedItemsBean getOrderedItems(Integer orderedItemsId)
	{
		return orderedItemsDAO.getOrderedItems(orderedItemsId);
	}
	
	@Autowired
	CustomerSittingService customerSittingService;
	
	@Autowired
	OrderService orderService;
	
	public List<OrderedItemsBean> findByOrderId(Integer tableId)
	{
		Integer customerSittingId = customerSittingService.findByTableId(tableId);
		String orderId = orderService.findByCustomerSittingId(customerSittingId);
		return orderedItemsDAO.findByOrderId(orderId);
	}
	
	
}