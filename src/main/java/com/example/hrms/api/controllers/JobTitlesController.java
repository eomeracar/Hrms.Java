package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitles")

public class JobTitlesController {
    private JobTitleService jobTitleService;
    @Autowired
    public JobTitlesController(JobTitleService jobTitleService){
        this.jobTitleService=jobTitleService;
    }

    @GetMapping("getall")
    public List<JobTitle> getAll(){
        return jobTitleService.getAll();
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<JobTitle> getById(@PathVariable int id) {
        return  new ResponseEntity<>(jobTitleService.getById(id), HttpStatus.OK);
    }

    @GetMapping("getallbyisactive")
    public List<JobTitle> getAllByIsActive(){
        return this.jobTitleService.getAllByIsActive();
    }

    @PostMapping("add")
    public void add(@RequestBody JobTitle jobTitle) {
        this.jobTitleService.add(jobTitle);
    }
}
