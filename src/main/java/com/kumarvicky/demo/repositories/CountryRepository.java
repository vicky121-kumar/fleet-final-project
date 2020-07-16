package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country,Integer> {
}
