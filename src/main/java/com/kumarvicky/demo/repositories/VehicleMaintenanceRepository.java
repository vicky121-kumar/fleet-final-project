package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance,Integer> {
}
