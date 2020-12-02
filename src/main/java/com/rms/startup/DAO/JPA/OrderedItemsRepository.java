package com.rms.startup.DAO.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.OrderedItemsEntity;

@Repository
public interface OrderedItemsRepository extends JpaRepository<OrderedItemsEntity, Integer>{
}
