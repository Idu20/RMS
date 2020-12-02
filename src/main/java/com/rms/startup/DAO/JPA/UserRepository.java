package com.rms.startup.DAO.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.startup.Entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}
