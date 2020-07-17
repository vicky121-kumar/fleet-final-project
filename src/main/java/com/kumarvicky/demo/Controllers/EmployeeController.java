package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Employee;
import com.kumarvicky.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired private StateService stateService;

    @Autowired private JobTitleService jobTitleService;

    @Autowired private EmployeeTypeService employeeTypeService;
    @Autowired private CountryService countryService;

    //Get All Employees
    @GetMapping("employee")
    public String findAll(Model model){
        model.addAttribute("country", countryService.getCountries());
        model.addAttribute("state", stateService.getState());
        model.addAttribute("employee", employeeService.findAll());
        model.addAttribute("jobTitle", jobTitleService.getJobTitle());
        model.addAttribute("employeeType", employeeTypeService.getEmployeeType());

        return "employee";
    }

    @RequestMapping("employee/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id)
    {
        return employeeService.findById(id);
    }

    //Add Employee
    @PostMapping(value="employee/addNew")
    public String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value="employee/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value="employee/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }


    @RequestMapping(value="/employee/uploadPhoto", method=RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
        newFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(newFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }


    @PostMapping("/employee/uploadPhoto2")
    public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal)
            throws IllegalStateException, IOException {
        String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
        file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
        return "redirect:/employee";
    }


    @RequestMapping(value="/employee/profile")
    public String profile(Model model, Principal principal) {
        String un = principal.getName();
        model.addAttribute("employee", employeeService.findByUsername(un));
        return "profile";
    }
}
