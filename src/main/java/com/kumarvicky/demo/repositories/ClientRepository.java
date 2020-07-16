package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client,Integer> {
}
