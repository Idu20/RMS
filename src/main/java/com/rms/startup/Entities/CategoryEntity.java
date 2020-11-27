package com.rms.startup.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.rms.startup.Bean.CategoryBean;

@Entity
public class CategoryEntity {
	@Id
	private Integer categoryId;
	private String categoryName;

	public CategoryEntity() {
		// TODO Auto-generated constructor stub
	}
	public CategoryEntity(CategoryBean bean)
	{
		this.categoryId = bean.getCategoryId();
		this.categoryName = bean.getCategoryName();
	}
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
