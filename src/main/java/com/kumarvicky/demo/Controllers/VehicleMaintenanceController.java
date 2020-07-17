package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.VehicleMaintenance;
import com.kumarvicky.demo.services.SupplierService;
import com.kumarvicky.demo.services.VehicleMaintenanceService;
import com.kumarvicky.demo.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired private VehicleService vehicleService;
    @Autowired private SupplierService supplierService;


    //Get All VehicleMaintenances
    @GetMapping("vehicleMaintenance")
    public String findAll(Model model){
        model.addAttribute("vehicleMaintenance", vehicleMaintenanceService.findAll());
        model.addAttribute("vehicle", vehicleService.findAll());
        model.addAttribute("supplier", supplierService.findAll());

        return "vehicleMaintenance";
    }

    @RequestMapping("vehicleMaintenance/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id)
    {
        return vehicleMaintenanceService.findById(id);
    }

    //Add VehicleMaintenance
    @PostMapping(value="vehicleMaintenance/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value="vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenance";
    }

    @RequestMapping(value="vehicleMaintenance/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenance";
    }

}
