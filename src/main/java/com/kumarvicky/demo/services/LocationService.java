package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.Location;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.repositories.LocationRepository;
import com.kumarvicky.demo.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    //Return List of Location
    public List<Location> getLocation()
    {
        return locationRepository.findAll();
    }

    //Save new Country
    public void save(Location location){
        locationRepository.save(location);
    }

    //get by id

    public Optional<Location> findById(int id)
    {
        return locationRepository.findById(id);
    }

    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }
}
