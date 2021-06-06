package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data//GETTER SETTER
@Entity//Entity
@AllArgsConstructor//WITH PARAM CONST
@NoArgsConstructor//WITHOUT PARAM CONST
@Table(name="job_titles")//Table
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_title_id")
    private int id;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name="created_user_id")
    private int createdUserId;

    @Column(name="modified_date")
    private Date modifiedDate;

    @Column(name="modified_user_id")
    private int modifiedUserId;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="title")
    private String title;
}
