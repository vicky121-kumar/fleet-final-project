package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.VehicleHire;
import com.kumarvicky.demo.services.ClientService;
import com.kumarvicky.demo.services.LocationService;
import com.kumarvicky.demo.services.VehicleHireService;
import com.kumarvicky.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired private ClientService clientService;
    @Autowired private LocationService locationService;
    @Autowired private VehicleService vehicleService;

    //Get All VehicleHires
    @GetMapping("vehicleHire")
    public String findAll(Model model){
        model.addAttribute("vehicleHire", vehicleHireService.findAll());
        model.addAttribute("client", clientService.findAll());
        model.addAttribute("location", locationService.getLocation());
        model.addAttribute("vehicle", vehicleService.findAll());

        return "vehicleHire";
    }

    @RequestMapping("vehicleHire/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id)
    {
        return vehicleHireService.findById(id);
    }

    //Add VehicleHire
    @PostMapping(value="vehicleHire/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value="vehicleHire/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHire";
    }

    @RequestMapping(value="vehicleHire/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHire";
    }



}
