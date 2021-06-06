package com.example.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;


    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
