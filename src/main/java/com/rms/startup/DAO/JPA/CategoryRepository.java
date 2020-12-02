package com.rms.startup.DAO.JPA;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.startup.Entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
