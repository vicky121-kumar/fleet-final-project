package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.JobTitle;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;
    @GetMapping("/jobTitle")
    public String Home(Model model)
    {

        List<JobTitle>jobTitleList=jobTitleService.getJobTitle();


        model.addAttribute("jobTitle",jobTitleList);
        return "jobTitle";
    }
    //Add new State
    @PostMapping("/jobTitle/addNew")
    public String addNew(JobTitle jobTitle)
    {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    //find jobTitle by id
    @RequestMapping("jobTitle/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id)
    {
        return jobTitleService.findById(id);

    }

    // update jobTitle data
    @RequestMapping(value = "/jobTitle/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateJobTitle(JobTitle jobTitle)
    {
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    //delete jobTitle
    @RequestMapping(value = "/jobTitle/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteJobTitle(@RequestParam int id)
    {
        jobTitleService.deleteJobTitle(id);
        return "redirect:/jobTitle";
    }
}
