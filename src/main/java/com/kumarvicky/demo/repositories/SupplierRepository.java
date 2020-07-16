package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
