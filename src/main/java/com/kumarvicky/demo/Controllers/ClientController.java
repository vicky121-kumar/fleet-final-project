package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Client;
import com.kumarvicky.demo.services.ClientService;
import com.kumarvicky.demo.services.CountryService;
import com.kumarvicky.demo.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ClientService clientService;

    //Get All Clients
    @GetMapping("/client")
    public String findAll(Model model){
        model.addAttribute("country", countryService.getCountries());
        model.addAttribute("state", stateService.getState());
        model.addAttribute("client", clientService.findAll());
        return "client";
    }

    @RequestMapping("client/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id)
    {
        return clientService.findById(id);
    }

    //Add Client
    @PostMapping(value="client/addNew")
    public String addNew(Client client) {
        clientService.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value="client/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value="client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        clientService.delete(id);
        return "redirect:/client";
    }

}
