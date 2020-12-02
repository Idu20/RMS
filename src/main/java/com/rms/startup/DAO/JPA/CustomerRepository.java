package com.rms.startup.DAO.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
