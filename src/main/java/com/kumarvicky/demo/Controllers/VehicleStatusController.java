package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.VehicleStatus;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;
    @GetMapping("/vehicleStatus")
    public String Home(Model model)
    {

        List<VehicleStatus>vehicleStatusList=vehicleStatusService.getVehicleStatus();


        model.addAttribute("vehicleStatus",vehicleStatusList);
        return "vehicleStatus";
    }
    //Add new State
    @PostMapping("/vehicleStatus/addNew")
    public String addNew(VehicleStatus vehicleStatus)
    {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    //find vehicleStatus by id
    @RequestMapping("vehicleStatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id)
    {
        return vehicleStatusService.findById(id);

    }

    // update vehicleStatus data
    @RequestMapping(value = "/vehicleStatus/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleStatus(VehicleStatus vehicleStatus)
    {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatus";
    }

    //delete vehicleStatus
    @RequestMapping(value = "/vehicleStatus/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleStatus(@RequestParam int id)
    {
        vehicleStatusService.deleteVehicleStatus(id);
        return "redirect:/vehicleStatus";
    }
}
