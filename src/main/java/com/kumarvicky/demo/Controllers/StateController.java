package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.CountryService;
import com.kumarvicky.demo.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private  CountryService countryService;
    @Autowired
    private StateService stateService;
    //StateService stateService=new StateService();
    @GetMapping("/state")
    public String Home(Model model)
    {
        List<State> stateList=stateService.getState();

        model.addAttribute("state",stateList);

        List<Country> countryList=countryService.getCountries();

        model.addAttribute("country",countryList);
        return "state";
    }
    //Add new State
    @PostMapping ("/state/addNew")
    public String addNew(State state)
    {
        stateService.save(state);
        return "redirect:/state";
    }

    //find state by id
    @RequestMapping("state/findById")
    @ResponseBody
    public Optional<State> findById(int id)
    {
        return stateService.findById(id);

    }

    // update state data
    @RequestMapping(value = "/state/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateState(State state)
    {
        stateService.save(state);
        return "redirect:/state";
    }

    //delete state
    @RequestMapping(value = "/state/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteState(@RequestParam int id)
    {
        stateService.deleteState(id);
        return "redirect:/state";
    }



}
