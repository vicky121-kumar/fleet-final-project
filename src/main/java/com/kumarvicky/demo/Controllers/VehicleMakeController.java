package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.VehicleMake;
import com.kumarvicky.demo.models.State;

import com.kumarvicky.demo.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @GetMapping("/vehicleMake")
    public String Home(Model model)
    {

        List<VehicleMake>vehicleMakeList=vehicleMakeService.getVehicleMake();


        model.addAttribute("vehicleMake",vehicleMakeList);
        return "vehicleMake";
    }
    //Add new State
    @PostMapping("/vehicleMake/addNew")
    public String addNew(VehicleMake vehicleMake)
    {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    //find vehicleMake by id
    @RequestMapping("vehicleMake/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id)
    {
        return vehicleMakeService.findById(id);

    }

    // update vehicleMake data
    @RequestMapping(value = "/vehicleMake/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleMake(VehicleMake vehicleMake)
    {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    //delete vehicleMake
    @RequestMapping(value = "/vehicleMake/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleMake(@RequestParam int id)
    {
        vehicleMakeService.deleteVehicleMake(id);
        return "redirect:/vehicleMake";
    }
}
