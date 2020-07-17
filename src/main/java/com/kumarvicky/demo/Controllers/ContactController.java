package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Contact;
import com.kumarvicky.demo.services.ContactService;
import com.kumarvicky.demo.services.CountryService;
import com.kumarvicky.demo.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private ContactService contactService;

    //Get All Contacts
    @GetMapping("/contact")
    public String findAll(Model model){
        model.addAttribute("country", countryService.getCountries());
        model.addAttribute("state", stateService.getState());
        model.addAttribute("contact", contactService.findAll());
        return "contact";
    }

    @RequestMapping("contact/findById")
    @ResponseBody
    public Optional<Contact> findById(Integer id)
    {
        return contactService.findById(id);
    }

    //Add Contact
    @PostMapping(value="contact/addNew")
    public String addNew(Contact contact) {
        contactService.save(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value="contact/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact) {
        contactService.save(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value="contact/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        contactService.delete(id);
        return "redirect:/contact";
    }
}
