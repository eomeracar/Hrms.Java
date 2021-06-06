package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateCheckService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.dataAccess.abstracts.CandidateRepository;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateRepository candidateRepository;
    private CandidateCheckService candidateCheckService;


    @Autowired
    public CandidateManager(CandidateRepository candidateRepository,CandidateCheckService candidateCheckService)
    {
        this.candidateRepository = candidateRepository;
        this.candidateCheckService=candidateCheckService;
    }

    @Override
    public boolean add(Candidate candidate) {
            if(!this.candidateCheckService.checkIdentityNumber(candidate.getIdentityNumber(),candidate.getFirstName(),candidate.getLastName(),candidate.getBirthDate()))
            {
                return false;
            }
            this.candidateRepository.save(candidate);
            return true;
    }

    @Override
    public List<Candidate> getAll() {
            return this.candidateRepository.findAll();
    }
}
