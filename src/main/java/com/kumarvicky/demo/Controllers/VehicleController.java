package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Vehicle;
import com.kumarvicky.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired private VehicleTypeService vehicleTypeService;
    @Autowired private VehicleMakeService vehicleMakeService;
    @Autowired private VehicleModelService vehicleModelService;
    @Autowired private LocationService locationService;
    @Autowired private EmployeeService employeeService ;
    @Autowired private VehicleStatusService vehicleStatusService;


    //Get All Vehicles
    @GetMapping("vehicle")
    public String findAll(Model model){
        model.addAttribute("vehicle", vehicleService.findAll());
        model.addAttribute("vehicleType", vehicleTypeService.getVehicleType());
        model.addAttribute("vehicleModel", vehicleModelService.getVehicleModel());
        model.addAttribute("vehicleMake", vehicleMakeService.getVehicleMake());
        model.addAttribute("location", locationService.getLocation());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("vehicleStatus", vehicleStatusService.getVehicleStatus());

        return "vehicle";
    }

    @RequestMapping("vehicle/findById")
    @ResponseBody
    public Optional<Vehicle> findById(Integer id)
    {
        return vehicleService.findById(id);
    }

    //Add Vehicle
    @PostMapping(value="vehicle/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @RequestMapping(value="vehicle/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicle";
    }

    @RequestMapping(value="vehicle/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicle";
    }
}
