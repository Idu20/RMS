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

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.Bean.ItemBean;
import com.rms.startup.Service.ItemService;

@RequestMapping("/item")
@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@GetMapping("/show")
	public List<ItemBean> showData() {
		return itemService.getAllItems();
	}
}
