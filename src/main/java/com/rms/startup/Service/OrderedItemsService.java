package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.OrderBean;
import com.rms.startup.Bean.OrderedItemsBean;
import com.rms.startup.DAO.OrderedItemsDAO;

@Service
public class OrderedItemsService {

	@Autowired
	OrderedItemsDAO orderedItemsDAO;

	@Autowired
	CustomerSittingService customerSittingService;
	
	@Autowired
	OrderService orderService;

	public List<OrderedItemsBean> getAllOrderedItemss() {
		return orderedItemsDAO.getAllOrderedItemss();
	}
	
	public String updateQuantity(int orderedItemsId,int quantity){
		OrderedItemsBean orderedItems = getOrderedItems(orderedItemsId);
		orderedItems.setQuantity(quantity);
		return updateOrderedItems(orderedItems);
	}
	
	public String addOrderedItems(OrderedItemsBean orderedItems){
		if(orderedItemsDAO.getOrderedItems(orderedItems.getOrderedItemsId()) == null)
		{
			orderedItemsDAO.addOrderedItems(orderedItems);
			OrderBean order = orderedItems.getOrder();
			order.setOrderTotal(order.getOrderTotal()+ (orderedItems.getQuantity() * orderedItems.getItem().getItemPrice()));
			orderService.updateOrder(order);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	
	
	public String updateOrderedItems(OrderedItemsBean orderedItems){
		if(orderedItemsDAO.getOrderedItems(orderedItems.getOrderedItemsId()) != null)
		{
			OrderedItemsBean prevOrderedItems = getOrderedItems(orderedItems.getOrderedItemsId());
			orderedItemsDAO.updateOrderedItems(orderedItems);
			OrderBean order = orderedItems.getOrder();
			order.setOrderTotal(order.getOrderTotal() - (prevOrderedItems.getQuantity() * prevOrderedItems.getItem().getItemPrice()));
			order.setOrderTotal(order.getOrderTotal() + (orderedItems.getQuantity() * orderedItems.getItem().getItemPrice()));
			orderService.updateOrder(order);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteOrderedItems(Integer orderedItemsId){
		if(orderedItemsDAO.getOrderedItems(orderedItemsId) != null)
		{
			try{
				OrderedItemsBean orderedItems = getOrderedItems(orderedItemsId);
 				OrderBean order = orderedItems.getOrder();
				order.setOrderTotal(order.getOrderTotal() - (orderedItems.getQuantity() * orderedItems.getItem().getItemPrice()));
				orderService.updateOrder(order);
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
	

	public List<OrderedItemsBean> findByOrderId(String orderId)
	{
		return orderedItemsDAO.findByOrderId(orderId);
	}
	
	public List<OrderedItemsBean> findByTableId(Integer tableId)
	{
		Integer customerSittingId = customerSittingService.findByTableId(tableId);
		String orderId = orderService.findByCustomerSittingId(customerSittingId);
		if(orderId == null)
		{
			orderService.createOrder(customerSittingId);
			return null;
		}
		else
		{
			return orderedItemsDAO.findByOrderId(orderId);
		}
	}
	
	
}