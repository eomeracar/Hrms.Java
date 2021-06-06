package com.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User{
    @NotBlank(message="neden null girdin gardaş?")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message="neden null girdin gardaş?")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message="neden null girdin gardaş?")
    @Column(name = "identity_number")
    private String identityNumber;
    @NotNull(message="NOT NULL")
    @Column(name = "birth_date")
    private Date birthDate;
}
