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

import com.rms.startup.Bean.OrderedItemsBean;
import com.rms.startup.Service.OrderedItemsService;

@RequestMapping("/orderedItems")
@RestController
public class OrderedItemsController {

	@Autowired
	OrderedItemsService orderedItemsService;

	@GetMapping("/show")
	public List<OrderedItemsBean> showData() {
		return orderedItemsService.getAllOrderedItemss();
	}
	
	@PostMapping("/add")
	public String addOrderedItems(@RequestBody OrderedItemsBean bean) {
		return orderedItemsService.addOrderedItems(bean);
	}

	@GetMapping("/show/{orderedItemsId}")
	public OrderedItemsBean getOrderedItems(@PathVariable Integer orderedItemsId) {
		return orderedItemsService.getOrderedItems(orderedItemsId);
	}

	@DeleteMapping("/delete/{orderedItemsId}")
	public String deleteOrderedItems(@PathVariable Integer orderedItemsId) {
		return orderedItemsService.deleteOrderedItems(orderedItemsId);
	}

	@PutMapping("/update")
	public String updateOrderedItems(@RequestBody OrderedItemsBean bean) {
		return orderedItemsService.updateOrderedItems(bean);
	}
}