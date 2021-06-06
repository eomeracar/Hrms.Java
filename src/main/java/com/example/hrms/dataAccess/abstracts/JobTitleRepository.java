package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
    //@Query("select j from JobTitle j where j.isActive = true and j.isDeleted = false")
    List<JobTitle> findAllByIsActiveTrueAndIsDeletedFalse();
}
