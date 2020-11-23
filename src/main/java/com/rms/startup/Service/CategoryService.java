package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Bean.CategoryBean;
import com.rms.startup.DAO.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO CategoryDAO;

	public List<CategoryBean> getAllCategory() {
		return CategoryDAO.getAllCategory();
	}

	public void addCategory(CategoryBean bean) {
		CategoryDAO.addCategory(bean);
	}

	public void deleteCategory(Integer categoryId) {
		CategoryDAO.deleteCategory(categoryId);
	}

	public CategoryBean getCategory(Integer categoryId) {
		System.out.println("CategoryId Service " + categoryId);
		return CategoryDAO.getCategory(categoryId);
	}

	public void updateCategory(Integer categoryId, CategoryBean bean) {
		CategoryDAO.updateCategory(categoryId, bean);
	}

}
