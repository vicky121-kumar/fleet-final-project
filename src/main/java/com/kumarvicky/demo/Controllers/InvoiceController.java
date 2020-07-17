package com.kumarvicky.demo.Controllers;

import com.kumarvicky.demo.models.Invoice;
import com.kumarvicky.demo.services.ClientService;
import com.kumarvicky.demo.services.InvoiceService;
import com.kumarvicky.demo.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired private InvoiceStatusService invoiceStatusService;
    @Autowired private ClientService clientService;

    //Get All Invoices
    @GetMapping("invoice")
    public String findAll(Model model){
        model.addAttribute("invoice", invoiceService.findAll());
        model.addAttribute("client", clientService.findAll());
        model.addAttribute("invoiceStatus", invoiceStatusService.getInvoiceStatus());
        return "invoice";
    }

    @RequestMapping("invoice/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id)
    {
        return invoiceService.findById(id);
    }

    //Add Invoice
    @PostMapping(value="invoice/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }

    @RequestMapping(value="invoice/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }

    @RequestMapping(value="invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoice";
    }
}
