package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobTitleRepository extends JpaRepository<JobTitle,Integer> {
}
