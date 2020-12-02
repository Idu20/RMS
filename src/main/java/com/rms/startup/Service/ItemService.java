package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Bean.ItemBean;
import com.rms.startup.DAO.ItemDAO;

@Service
public class ItemService {

	@Autowired
	ItemDAO itemDAO;

	public List<ItemBean> getAllItems() {
		return itemDAO.getAllItems();
	}
}