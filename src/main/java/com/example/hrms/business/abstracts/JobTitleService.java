package com.example.hrms.business.abstracts;

import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    List<JobTitle> getAll();
    void add(JobTitle jobTitle);
    JobTitle getById(int id);
    List<JobTitle> getAllByIsActive();
}
