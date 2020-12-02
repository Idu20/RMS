package com.rms.startup.DAO.JPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.UserEntity;;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
}
