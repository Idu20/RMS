package com.rms.startup.DAO.JPA;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.startup.Entities.CategoryEntity;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
