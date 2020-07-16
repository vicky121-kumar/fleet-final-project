package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}
