package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.dataAccess.abstracts.JobTitleRepository;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleRepository jobTitleRepository;

    @Autowired//To Activate DependencyIncetion IOC Container
    public JobTitleManager(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobTitleRepository.findAll();
    }

    @Override
    public void add(JobTitle jobTitle) {
        this.jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle getById(int id) {
        return this.jobTitleRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobTitle> getAllByIsActive() {
        return this.jobTitleRepository.findAllByIsActiveTrueAndIsDeletedFalse();
    }
}
