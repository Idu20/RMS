package com.rms.startup.DAO.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{

}
