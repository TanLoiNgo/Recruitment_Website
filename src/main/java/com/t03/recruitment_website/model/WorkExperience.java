package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "work_experience")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long work_Experience_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;


    @NotEmpty
    @Column(name = "work_experience_name")
    private String work_experience_name;

    @NotEmpty
    @Column(name = "company_name")
    private String company_name;

    @NotEmpty
    @Column(name = "job_location")
    private String job_location;

    @NotEmpty
    @Column(name = "is_current_job")
    private String is_current_job;

    @NotEmpty
    @Column(name = "Start_date")
    private Date Start_date;

    @NotEmpty
    @Column(name = "end_date")
    private Date end_date;

    @NotEmpty
    @Column(name = "experience_description")
    private String experience_description;

    public WorkExperience(){

    }

    public WorkExperience(JobSeeker jobSeekers, String work_experience_name, String company_name, String job_location, String is_current_job, Date start_date, Date end_date, String experience_description) {
        this.jobSeekers = jobSeekers;
        this.work_experience_name = work_experience_name;
        this.company_name = company_name;
        this.job_location = job_location;
        this.is_current_job = is_current_job;
        Start_date = start_date;
        this.end_date = end_date;
        this.experience_description = experience_description;
    }

    public Long getWork_Experience_ID() {
        return work_Experience_ID;
    }

    public void setWork_Experience_ID(Long work_Experience_ID) {
        this.work_Experience_ID = work_Experience_ID;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getWork_experience_name() {
        return work_experience_name;
    }

    public void setWork_experience_name(String work_experience_name) {
        this.work_experience_name = work_experience_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getIs_current_job() {
        return is_current_job;
    }

    public void setIs_current_job(String is_current_job) {
        this.is_current_job = is_current_job;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date start_date) {
        Start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getExperience_description() {
        return experience_description;
    }

    public void setExperience_description(String experience_description) {
        this.experience_description = experience_description;
    }
}
