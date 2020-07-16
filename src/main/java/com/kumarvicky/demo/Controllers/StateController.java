//package com.kumarvicky.demo.Controllers;
//
//import com.kumarvicky.demo.models.State;
//import com.kumarvicky.demo.services.CountryService;
//import com.kumarvicky.demo.services.StateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//public class StateController {
//
//    @GetMapping("/states")
//    public String getState()
//    {
//        return "State";
//    }
//
//    @Autowired
//    private StateService stateService;
//    @GetMapping("/state")
//    public String Home(Model model)
//    {
//        List<State> stateList=stateService.getCountries();
//
//        model.addAttribute("state",stateList);
//        return "state";
//    }
//    //Add new country
//    @PostMapping("/state/addNew")
//    public String addNew(State state)
//    {
//        stateService.save(state);
//        return "redirect:/state";
//    }
//
//    //find country by id
//    @RequestMapping("state/findById")
//    @ResponseBody
//    public Optional<State> findById(int id)
//    {
//        return stateService.findById(id);
//
//    }
//
//    // update country data
//    @RequestMapping(value = "/state/update",method = {RequestMethod.PUT,RequestMethod.GET})
//    public String updateState(State state)
//    {
//        stateService.save(state);
//        return "redirect:/state";
//    }
//
//    //delete country
//    @RequestMapping(value = "/state/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
//    public String deleteCountry(@RequestParam int id)
//    {
//        stateService.deleteCountry(id);
//        return "redirect:/state";
//    }
//
//
//}
