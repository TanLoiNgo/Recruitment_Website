package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long company_ID;

    @NotEmpty
    @Column(name = "company_name")
    private String company_name;


    @Column(name = "company_description")
    private String company_description;


    @Column(name = "company_website")
    private String company_website;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<JobPosting> jobPostings = new HashSet<>();

    public Company(){

    }

    public Company(String company_name, String company_description, String company_website) {
        this.company_name = company_name;
        this.company_description = company_description;
        this.company_website = company_website;
    }

    public Long getCompany_ID() {
        return company_ID;
    }

    public void setCompany_ID(Long company_ID) {
        this.company_ID = company_ID;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_description() {
        return company_description;
    }

    public void setCompany_description(String company_description) {
        this.company_description = company_description;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public Set<JobPosting> getJobPostings() {
        return jobPostings;
    }

    public void setJobPostings(Set<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }
}
