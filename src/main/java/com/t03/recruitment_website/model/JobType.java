package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job_type")
public class JobType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long job_type_ID;

    @NotEmpty
    @Column(name = "job_type_name")
    private String job_type_name;

    @OneToMany(mappedBy = "jobTypes", cascade = CascadeType.ALL)
    private Set<JobPosting> jobPostings = new HashSet<>();

    public  JobType(){

    }

    public JobType(String job_type_name) {
        this.job_type_name = job_type_name;
    }

    public Long getJob_type_ID() {
        return job_type_ID;
    }

    public void setJob_type_ID(Long job_type_ID) {
        this.job_type_ID = job_type_ID;
    }

    public String getJob_type_name() {
        return job_type_name;
    }

    public void setJob_type_name(String job_type_name) {
        this.job_type_name = job_type_name;
    }

    public Set<JobPosting> getJobPostings() {
        return jobPostings;
    }

    public void setJobPostings(Set<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }
}
