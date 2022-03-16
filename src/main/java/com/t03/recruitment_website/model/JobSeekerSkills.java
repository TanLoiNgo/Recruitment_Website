package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "job_seeker_skills")
public class JobSeekerSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long job_seeker_skill_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;

    @NotEmpty
    @Column(name = "skill_name")
    private String skill_name;

    @NotEmpty
    @Column(name = "skill_level")
    private String skill_level;

    public JobSeekerSkills(){

    }

    public JobSeekerSkills(JobSeeker jobSeekers, String skill_name, String skill_level) {
        this.jobSeekers = jobSeekers;
        this.skill_name = skill_name;
        this.skill_level = skill_level;
    }

    public Long getJob_seeker_skill_ID() {
        return job_seeker_skill_ID;
    }

    public void setJob_seeker_skill_ID(Long job_seeker_skill_ID) {
        this.job_seeker_skill_ID = job_seeker_skill_ID;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(String skill_level) {
        this.skill_level = skill_level;
    }
}
