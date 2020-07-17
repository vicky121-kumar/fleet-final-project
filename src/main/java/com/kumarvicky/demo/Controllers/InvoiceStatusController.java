package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Country;
import com.kumarvicky.demo.models.InvoiceStatus;
import com.kumarvicky.demo.models.State;
import com.kumarvicky.demo.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
     
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @GetMapping("/invoiceStatus")
    public String Home(Model model)
    {

        List<InvoiceStatus>invoiceStatusList=invoiceStatusService.getInvoiceStatus();


        model.addAttribute("invoiceStatus",invoiceStatusList);
        return "invoiceStatus";
    }
    //Add new State
    @PostMapping("/invoiceStatus/addNew")
    public String addNew(InvoiceStatus invoiceStatus)
    {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    //find invoiceStatus by id
    @RequestMapping("invoiceStatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id)
    {
        return invoiceStatusService.findById(id);

    }

    // update invoiceStatus data
    @RequestMapping(value = "/invoiceStatus/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    //delete invoiceStatus
    @RequestMapping(value = "/invoiceStatus/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoiceStatus(@RequestParam int id)
    {
        invoiceStatusService.deleteInvoiceStatus(id);
        return "redirect:/invoiceStatus";
    }
}
