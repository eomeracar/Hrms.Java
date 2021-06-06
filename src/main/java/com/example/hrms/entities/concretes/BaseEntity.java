package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Data
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date", updatable = false)
    private Instant createDate = Instant.now();

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "modified_date")
    private Instant modifiedDate = Instant.now();
}
