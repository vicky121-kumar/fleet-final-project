package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.VehicleMovement;
import com.kumarvicky.demo.services.LocationService;
import com.kumarvicky.demo.services.VehicleMovementService;
import com.kumarvicky.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;

    //Get All VehicleMovements
    @GetMapping("vehicleMovement")
    public String findAll(Model model){
        model.addAttribute("vehicleMovement", vehicleMovementService.findAll());
        model.addAttribute("location", locationService.getLocation());
        model.addAttribute("vehicle", vehicleService.findAll());

        return "vehicleMovement";
    }

    @RequestMapping("vehicleMovement/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id)
    {
        return vehicleMovementService.findById(id);
    }

    //Add VehicleMovement
    @PostMapping(value="vehicleMovement/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping(value="vehicleMovement/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovement";
    }

    @RequestMapping(value="vehicleMovement/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovement";
    }
}
