package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "languages")
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long language_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;

    @NotEmpty
    @Column(name = "language_name")
    private String language_name;

    @NotEmpty
    @Column(name = "proficiency_level")
    private String proficiency_level;

    public Languages(){

    }

    public Languages(JobSeeker jobSeekers, String language_name, String proficiency_level) {
        this.jobSeekers = jobSeekers;
        this.language_name = language_name;
        this.proficiency_level = proficiency_level;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    public String getProficiency_level() {
        return proficiency_level;
    }

    public void setProficiency_level(String proficiency_level) {
        this.proficiency_level = proficiency_level;
    }
}
