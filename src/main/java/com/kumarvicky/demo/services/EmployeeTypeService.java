package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.EmployeeType;
import com.kumarvicky.demo.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    //Return List of EmployeeType
    public List<EmployeeType> getEmployeeType()
    {
        return employeeTypeRepository.findAll();
    }

    //Save new Country
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    //get by id

    public Optional<EmployeeType> findById(int id)
    {
        return employeeTypeRepository.findById(id);
    }

    public void deleteEmployeeType(int id) {
        employeeTypeRepository.deleteById(id);
    }
}
