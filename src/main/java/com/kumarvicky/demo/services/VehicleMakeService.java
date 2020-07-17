package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.Location;
import com.kumarvicky.demo.models.VehicleMake;
import com.kumarvicky.demo.repositories.LocationRepository;
import com.kumarvicky.demo.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    //Return List of VehicleMake
    public List<VehicleMake> getVehicleMake()
    {
        return vehicleMakeRepository.findAll();
    }

    //Save new Country
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    //get by id

    public Optional<VehicleMake> findById(int id)
    {
        return vehicleMakeRepository.findById(id);
    }

    public void deleteVehicleMake(int id) {
        vehicleMakeRepository.deleteById(id);
    }
}
