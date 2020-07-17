package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.EmployeeType;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;
    @GetMapping("/employeeType")
    public String Home(Model model)
    {

        List<EmployeeType>employeeTypeList=employeeTypeService.getEmployeeType();


        model.addAttribute("employeeType",employeeTypeList);
        return "employeeType";
    }
    //Add new State
    @PostMapping("/employeeType/addNew")
    public String addNew(EmployeeType employeeType)
    {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    //find employeeType by id
    @RequestMapping("employeeType/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id)
    {
        return employeeTypeService.findById(id);

    }

    // update employeeType data
    @RequestMapping(value = "/employeeType/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateEmployeeType(EmployeeType employeeType)
    {
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    //delete employeeType
    @RequestMapping(value = "/employeeType/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteEmployeeType(@RequestParam int id)
    {
        employeeTypeService.deleteEmployeeType(id);
        return "redirect:/employeeType";
    }
}
