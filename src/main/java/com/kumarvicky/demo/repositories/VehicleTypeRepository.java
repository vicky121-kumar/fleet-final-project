package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {
}
