package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.InvoiceStatus;
import com.kumarvicky.demo.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    //Return List of InvoiceStatus
    public List<InvoiceStatus> getInvoiceStatus()
    {
        return invoiceStatusRepository.findAll();
    }

    //Save new Country
    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    //get by id

    public Optional<InvoiceStatus> findById(int id)
    {
        return invoiceStatusRepository.findById(id);
    }

    public void deleteInvoiceStatus(int id) {
        invoiceStatusRepository.deleteById(id);
    }
}
