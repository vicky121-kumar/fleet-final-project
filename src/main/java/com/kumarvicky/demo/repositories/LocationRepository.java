package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Integer> {
}
