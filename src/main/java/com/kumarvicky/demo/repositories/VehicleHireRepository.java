package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleHireRepository extends JpaRepository<VehicleHire,Integer> {
}
