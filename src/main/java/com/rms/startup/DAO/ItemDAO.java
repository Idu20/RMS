package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.ItemBean;
import com.rms.startup.DAO.JPA.ItemRepository;
import com.rms.startup.Entities.ItemEntity;

@Repository
public class ItemDAO {

	@Autowired
	ItemRepository repo;

	public List<ItemBean> getAllItems() {
		List<ItemEntity> lst = repo.findAll();
		List<ItemBean> returnlst = new ArrayList<ItemBean>();
		for(ItemEntity Item : lst)
			returnlst.add(Item.convertToBean());
		return returnlst;
	}
}