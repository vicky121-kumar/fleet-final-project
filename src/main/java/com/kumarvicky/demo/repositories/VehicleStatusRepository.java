package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleStatusRepository extends JpaRepository<VehicleStatus,Integer> {
}
