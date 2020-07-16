package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.kumarvicky.demo.services.CountryService;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {


      @Autowired
      private CountryService countryService;
     //CountryService countryService=new CountryService();
    @GetMapping("/country")
    public String Home(Model model)
    {
        List<Country> countryList=countryService.getCountries();

        model.addAttribute("country",countryList);
        return "country";
    }
    //Add new country
    @PostMapping ("/country/addNew")
    public String addNew(Country country)
    {
        countryService.save(country);
        return "redirect:/country";
    }

    //find country by id
    @RequestMapping("country/findById")
    @ResponseBody
    public Optional<Country> findById(int id)
    {
        return countryService.findById(id);

    }

    // update country data
    @RequestMapping(value = "/country/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateCountry(Country country)
    {
        countryService.save(country);
        return "redirect:/country";
    }

    //delete country
    @RequestMapping(value = "/country/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCountry(@RequestParam int id)
    {
        countryService.deleteCountry(id);
        return "redirect:/country";
    }



}
