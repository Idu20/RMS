package com.rms.startup.DAO.JPA;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.startup.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>
{}
