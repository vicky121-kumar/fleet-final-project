package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.VehicleStatus;
import com.kumarvicky.demo.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Return List of VehicleStatus
    public List<VehicleStatus> getVehicleStatus()
    {
        return vehicleStatusRepository.findAll();
    }

    //Save new Country
    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    //get by id

    public Optional<VehicleStatus> findById(int id)
    {
        return vehicleStatusRepository.findById(id);
    }

    public void deleteVehicleStatus(int id) {
        vehicleStatusRepository.deleteById(id);
    }
}
