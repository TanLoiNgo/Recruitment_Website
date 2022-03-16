package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "certificates")
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificate_ID;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_ID")
    private JobSeeker jobSeekers;

    @NotEmpty
    @Column(name = "certificate_name")
    private String certificate_name;

    @NotEmpty
    @Column(name = "certificate_description")
    private String certificate_description;

    @NotEmpty
    @Column(name = "start_Date")
    private Date start_Date;

    @NotEmpty
    @Column(name = "end_Date")
    private Date end_Date;

    public Certificates(){

    }

    public Certificates(JobSeeker jobSeekers, String certificate_name, String certificate_description, Date start_Date, Date end_Date) {
        this.jobSeekers = jobSeekers;
        this.certificate_name = certificate_name;
        this.certificate_description = certificate_description;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public Long getCertificate_ID() {
        return certificate_ID;
    }

    public void setCertificate_ID(Long certificate_ID) {
        this.certificate_ID = certificate_ID;
    }

    public JobSeeker getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(JobSeeker jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_description() {
        return certificate_description;
    }

    public void setCertificate_description(String certificate_description) {
        this.certificate_description = certificate_description;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }
}
