package com.kumarvicky.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehiceMakeController {

    @GetMapping("vehiclemake")
    public String getVehicleMake()
    {
        return "VehicleMake";
    }
}
