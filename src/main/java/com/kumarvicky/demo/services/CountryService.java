package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kumarvicky.demo.repositories.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
   private  CountryRepository countryRepository;

    //Return List of Countries
    public List<Country> getCountries()
    {
        return countryRepository.findAll();
    }

    //Save new Country
    public void save(Country country){
        countryRepository.save(country);
    }

    //get by id

    public Optional<Country> findById(int id)
    {
        return countryRepository.findById(id);
    }

    public void deleteCountry(int id) {
        countryRepository.deleteById(id);
    }
}
