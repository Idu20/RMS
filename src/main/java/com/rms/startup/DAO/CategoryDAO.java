package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.DAO.JPA.CategoryRepository;
import com.rms.startup.Entities.CategoryEntity;

@Repository
public class CategoryDAO {

	@Autowired
	CategoryRepository repo;

	public List<CategoryBean> getAllCategory() {
		List<CategoryEntity> lst = repo.findAll();
		List<CategoryBean> returnlst = new ArrayList<CategoryBean>();
		for(CategoryEntity category : lst)
			returnlst.add(category.convertToBean());
		return returnlst;
	}

	public void addCategory(CategoryBean bean) {
		//jdbcTemplate.update("insert into Category(CategoryId,CategoryName) values(?,?)", bean.getCategoryId(),
			//	bean.getCategoryName());
	}

	public void deleteCategory(Integer categoryId) {
	//	jdbcTemplate.update("delete from Category where categoryId=?", categoryId);
	}

	public CategoryBean getCategory(Integer categoryId) {
		return null;
//		System.out.println("Category Id DAO " + categoryId);
//		return jdbcTemplate.queryForObject("select * from Category where categoryId=?", new BeanPropertyRowMapper<>(CategoryBean.class), categoryId);
	}

	public void updateCategory(Integer categoryId, CategoryBean bean) {
//		jdbcTemplate.update("update Category set categoryId=?,CategoryName=? where categoryId=?", bean.getCategoryId(),
//				bean.getCategoryName(), categoryId);
	}

}
