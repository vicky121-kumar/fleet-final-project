package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
