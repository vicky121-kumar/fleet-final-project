package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Supplier;
import com.kumarvicky.demo.services.CountryService;
import com.kumarvicky.demo.services.StateService;
import com.kumarvicky.demo.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private SupplierService supplierService;

    //Get All Suppliers
    @GetMapping("supplier")
    public String findAll(Model model){
        model.addAttribute("country", countryService.getCountries());
        model.addAttribute("state", stateService.getState());
        model.addAttribute("supplier", supplierService.findAll());
        return "supplier";
    }

    @RequestMapping("supplier/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id)
    {
        return supplierService.findById(id);
    }

    //Add Supplier
    @PostMapping(value="supplier/addNew")
    public String addNew(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @RequestMapping(value="supplier/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/supplier";
    }

    @RequestMapping(value="supplier/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        supplierService.delete(id);
        return "redirect:/supplier";
    }


}
