//package com.kumarvicky.demo.services;
//
//import com.kumarvicky.demo.models.State;
//import com.kumarvicky.demo.repositories.CountryRepository;
//import com.kumarvicky.demo.repositories.StateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StateService {
//
//    @Autowired
//    private StateRepository stateRepository;
//
//    //Return List of State
//    public List<State> getCountries()
//    {
//        return stateRepository.findAll();
//    }
//
//    //Save new Country
//    public void save(State state){
//        stateRepository.save(state);
//    }
//
//    //get by id
//
//    public Optional<State> findById(int id)
//    {
//        return stateRepository.findById(id);
//    }
//
//    public void deleteCountry(int id) {
//        stateRepository.deleteById(id);
//    }
//}
