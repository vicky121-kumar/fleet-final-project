package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.State;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StateRepository extends JpaRepository<State,Integer> {
}
