package com.kumarvicky.demo.services;

import com.kumarvicky.demo.models.JobTitle;
import com.kumarvicky.demo.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    //Return List of JobTitle
    public List<JobTitle> getJobTitle()
    {
        return jobTitleRepository.findAll();
    }

    //Save new Country
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    //get by id

    public Optional<JobTitle> findById(int id)
    {
        return jobTitleRepository.findById(id);
    }

    public void deleteJobTitle(int id) {
        jobTitleRepository.deleteById(id);
    }
}
