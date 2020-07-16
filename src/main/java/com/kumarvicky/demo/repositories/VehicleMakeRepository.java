package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleMakeRepository extends JpaRepository<VehicleMake,Integer> {
}
