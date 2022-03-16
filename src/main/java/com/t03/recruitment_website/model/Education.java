package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long education_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;

    @NotEmpty
    @Column(name = "level_of_education")
    private String level_of_education;

    @NotEmpty
    @Column(name = "major")
    private String major;

    @NotEmpty
    @Column(name = "school_name")
    private String school_name;

    @NotEmpty
    @Column(name = "school_address")
    private String school_address;

    @Column(name = "is_current_school")
    private String is_current_school;

    @NotEmpty
    @Column(name = "starting_date")
    private Date starting_date;

    @Column(name = "completion_date")
    private Date completion_date;

    public Education(){}

    public Education(JobSeeker jobSeekers, String level_of_education, String major, String school_name, String school_address, String is_current_school, Date starting_date, Date completion_date) {
        this.jobSeekers = jobSeekers;
        this.level_of_education = level_of_education;
        this.major = major;
        this.school_name = school_name;
        this.school_address = school_address;
        this.is_current_school = is_current_school;
        this.starting_date = starting_date;
        this.completion_date = completion_date;
    }

    public Long getEducation_ID() {
        return education_ID;
    }

    public void setEducation_ID(Long education_ID) {
        this.education_ID = education_ID;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getLevel_of_education() {
        return level_of_education;
    }

    public void setLevel_of_education(String level_of_education) {
        this.level_of_education = level_of_education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_address() {
        return school_address;
    }

    public void setSchool_address(String school_address) {
        this.school_address = school_address;
    }

    public String getIs_current_school() {
        return is_current_school;
    }

    public void setIs_current_school(String is_current_school) {
        this.is_current_school = is_current_school;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public Date getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(Date completion_date) {
        this.completion_date = completion_date;
    }
}
