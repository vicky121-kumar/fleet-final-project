package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleModelRepository extends JpaRepository<VehicleModel,Integer> {
}
