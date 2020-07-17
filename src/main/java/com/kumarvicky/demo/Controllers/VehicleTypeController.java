package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.VehicleType;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;
    @GetMapping("/vehicleType")
    public String Home(Model model)
    {

        List<VehicleType>vehicleTypeList=vehicleTypeService.getVehicleType();


        model.addAttribute("vehicleType",vehicleTypeList);
        return "vehicleType";
    }
    //Add new State
    @PostMapping("/vehicleType/addNew")
    public String addNew(VehicleType vehicleType)
    {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    //find vehicleType by id
    @RequestMapping("vehicleType/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id)
    {
        return vehicleTypeService.findById(id);

    }

    // update vehicleType data
    @RequestMapping(value = "/vehicleType/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleType(VehicleType vehicleType)
    {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    //delete vehicleType
    @RequestMapping(value = "/vehicleType/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleType(@RequestParam int id)
    {
        vehicleTypeService.deleteVehicleType(id);
        return "redirect:/vehicleType";
    }
}
