package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "applied_job")
public class AppliedJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applied_job_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;

    @ManyToOne()
    @JoinColumn(name = "job_posting_ID")
    private JobPosting jobPosting;

    @NotEmpty
    @Column(name = "resume_location")
    private String resume_location;

    @NotEmpty
    @Column(name = "action_date")
    private Date action_date;

    public  AppliedJob(){

    }


    public AppliedJob(JobSeeker jobSeekers, JobPosting jobPosting, String resume_location, Date action_date) {
        this.jobSeekers = jobSeekers;
        this.jobPosting = jobPosting;
        this.resume_location = resume_location;
        this.action_date = action_date;
    }

    public Long getApplied_job_ID() {
        return applied_job_ID;
    }

    public void setApplied_job_ID(Long applied_job_ID) {
        this.applied_job_ID = applied_job_ID;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public String getResume_location() {
        return resume_location;
    }

    public void setResume_location(String resume_location) {
        this.resume_location = resume_location;
    }

    public Date getAction_date() {
        return action_date;
    }

    public void setAction_date(Date action_date) {
        this.action_date = action_date;
    }
}
