package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService)
    {
        this.candidateService = candidateService;
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@Valid @RequestBody Candidate candidate)
    {

        boolean result=this.candidateService.add(candidate);
        if(result)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}
