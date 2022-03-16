package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "workplace_type")
public class Workplace_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workplace_type_ID;

    @NotEmpty
    @Column(name = "workplace_type_name")
    private String workplace_type_name;

    @OneToMany(mappedBy = "workplaceType", cascade = CascadeType.ALL)
    private Set<JobPosting> jobPostings = new HashSet<>();

    public  Workplace_Type(){

    }

    public Workplace_Type(String workplace_type_name) {
        this.workplace_type_name = workplace_type_name;
    }

    public Long getWorkplace_type_ID() {
        return workplace_type_ID;
    }

    public void setWorkplace_type_ID(Long workplace_type_ID) {
        this.workplace_type_ID = workplace_type_ID;
    }

    public String getWorkplace_type_name() {
        return workplace_type_name;
    }

    public void setWorkplace_type_name(String workplace_type_name) {
        this.workplace_type_name = workplace_type_name;
    }

    public Set<JobPosting> getJobPostings() {
        return jobPostings;
    }

    public void setJobPostings(Set<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }
}
