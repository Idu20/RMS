package com.rms.startup.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CategoryBean;

@Repository
public class CategoryDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<CategoryBean> getAllCategory() {
		return jdbcTemplate.query("select * from Category;",
				new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class));
	}

	public void addCategory(CategoryBean bean) {
		jdbcTemplate.update("insert into Category(CategoryId,CategoryName) values(?,?)", bean.getCategoryId(),
				bean.getCategoryName());
	}

	public void deleteCategory(Integer categoryId) {
		jdbcTemplate.update("delete from Category where categoryId=?", categoryId);
	}

	public CategoryBean getCategory(Integer categoryId) {
		System.out.println("Category Id DAO " + categoryId);
		return jdbcTemplate.queryForObject("select * from Category where categoryId=?", new BeanPropertyRowMapper<>(CategoryBean.class), categoryId);
	}

	public void updateCategory(Integer categoryId, CategoryBean bean) {
		jdbcTemplate.update("update Category set categoryId=?,CategoryName=? where categoryId=?", bean.getCategoryId(),
				bean.getCategoryName(), categoryId);
	}

}
