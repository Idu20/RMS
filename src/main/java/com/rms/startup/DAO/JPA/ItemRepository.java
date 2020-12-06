package com.rms.startup.DAO.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.ItemEntity;
import com.rms.startup.Bean.CategoryBean;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
	public List<ItemEntity> findByCategoryCategoryId(Integer categoryId);
}
