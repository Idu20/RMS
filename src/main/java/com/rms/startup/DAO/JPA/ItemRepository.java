package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{

	@Query("select i from ItemEntity i where categoryid = ?1")
	List<ItemEntity> getByCategory(Integer categoryid);
}
