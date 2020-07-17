package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.VehicleModel;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;
    @GetMapping("/vehicleModel")
    public String Home(Model model)
    {

        List<VehicleModel>vehicleModelList=vehicleModelService.getVehicleModel();


        model.addAttribute("vehicleModel",vehicleModelList);
        return "vehicleModel";
    }
    //Add new State
    @PostMapping("/vehicleModel/addNew")
    public String addNew(VehicleModel vehicleModel)
    {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    //find vehicleModel by id
    @RequestMapping("vehicleModel/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id)
    {
        return vehicleModelService.findById(id);

    }

    // update vehicleModel data
    @RequestMapping(value = "/vehicleModel/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleModel(VehicleModel vehicleModel)
    {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    //delete vehicleModel
    @RequestMapping(value = "/vehicleModel/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleModel(@RequestParam int id)
    {
        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/vehicleModel";
    }
}
