package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus,Integer> {
}
