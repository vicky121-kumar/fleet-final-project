package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.VehicleModel;
import com.kumarvicky.demo.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Return List of VehicleModel
    public List<VehicleModel> getVehicleModel()
    {
        return vehicleModelRepository.findAll();
    }

    //Save new Country
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    //get by id

    public Optional<VehicleModel> findById(int id)
    {
        return vehicleModelRepository.findById(id);
    }

    public void deleteVehicleModel(int id) {
        vehicleModelRepository.deleteById(id);
    }
}
