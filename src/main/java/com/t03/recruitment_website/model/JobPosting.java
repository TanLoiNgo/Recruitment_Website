package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job_posting")
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long job_posting_ID;

    @ManyToOne()
    @JoinColumn(name = "user_ID")
    private Users users;

    @ManyToOne()
    @JoinColumn(name = "job_type_ID")
    private JobType jobTypes;

    @ManyToOne()
    @JoinColumn(name = "workplace_type_ID")
    private Workplace_Type workplaceType;

    @ManyToOne()
    @JoinColumn(name = "company_ID")
    private Company company;

    @NotEmpty
    @Column(name = "job_title")
    private String job_title;

    @NotEmpty
    @Column(name = "job_description")
    private String job_description;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "city")
    private String city;

    @NotEmpty
    @Column(name = "postal_code")
    private String postal_code;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @NotEmpty
    @Column(name = "is_active")
    private Boolean is_active;

    @NotEmpty
    @Column(name = "job_posting_description")
    private String job_posting_description;

    @OneToMany(mappedBy = "jobPosting", cascade = CascadeType.ALL)
    private Set<AppliedJob> appliedJobs = new HashSet<>();

    public JobPosting(){

    }

    public JobPosting(String job_title, String job_description, String address, String city, String postal_code, String country, Boolean is_active, String job_posting_description) {
        this.job_title = job_title;
        this.job_description = job_description;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.is_active = is_active;
        this.job_posting_description = job_posting_description;
    }

    public Long getJob_posting_ID() {
        return job_posting_ID;
    }

    public void setJob_posting_ID(Long job_posting_ID) {
        this.job_posting_ID = job_posting_ID;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public JobType getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(JobType jobTypes) {
        this.jobTypes = jobTypes;
    }

    public Workplace_Type getWorkplaceType() {
        return workplaceType;
    }

    public void setWorkplaceType(Workplace_Type workplaceType) {
        this.workplaceType = workplaceType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getJob_posting_description() {
        return job_posting_description;
    }

    public void setJob_posting_description(String job_posting_description) {
        this.job_posting_description = job_posting_description;
    }

    public Set<AppliedJob> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(Set<AppliedJob> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }
}
