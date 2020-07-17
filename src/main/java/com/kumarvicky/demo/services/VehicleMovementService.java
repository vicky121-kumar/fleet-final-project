package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.VehicleMovement;
import com.kumarvicky.demo.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {
    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    //Get All VehicleMovements
    public List<VehicleMovement> findAll(){
        return vehicleMovementRepository.findAll();
    }

    //Get VehicleMovement By Id
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    //Delete VehicleMovement
    public void delete(int id) {
        vehicleMovementRepository.deleteById(id);
    }

    //Update VehicleMovement
    public void save(VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }
}
