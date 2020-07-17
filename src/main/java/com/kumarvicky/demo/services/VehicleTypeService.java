package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.VehicleType;
import com.kumarvicky.demo.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    //Return List of VehicleType
    public List<VehicleType> getVehicleType()
    {
        return vehicleTypeRepository.findAll();
    }

    //Save new Country
    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    //get by id

    public Optional<VehicleType> findById(int id)
    {
        return vehicleTypeRepository.findById(id);
    }

    public void deleteVehicleType(int id) {
        vehicleTypeRepository.deleteById(id);
    }
}
