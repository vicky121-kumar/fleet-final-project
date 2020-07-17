package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.Location;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.CountryService;
import com.kumarvicky.demo.services.LocationService;
import com.kumarvicky.demo.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    @Autowired
    private LocationService locationService;
    @GetMapping("/location")
    public String Home(Model model)
    {
        List<State> stateList=stateService.getState();
        List<Country> countryList=countryService.getCountries();
        List<Location>locationList=locationService.getLocation();

        model.addAttribute("state",stateList);
        model.addAttribute("country",countryList);
        model.addAttribute("location",locationList);
        return "location";
    }
    //Add new State
    @PostMapping("/location/addNew")
    public String addNew(Location location)
    {
        locationService.save(location);
        return "redirect:/location";
    }

    //find location by id
    @RequestMapping("location/findById")
    @ResponseBody
    public Optional<Location> findById(int id)
    {
        return locationService.findById(id);

    }

    // update location data
    @RequestMapping(value = "/location/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateLocation(Location location)
    {
        locationService.save(location);
        return "redirect:/location";
    }

    //delete location
    @RequestMapping(value = "/location/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteLocation(@RequestParam int id)
    {
        locationService.deleteLocation(id);
        return "redirect:/location";
    }


}
