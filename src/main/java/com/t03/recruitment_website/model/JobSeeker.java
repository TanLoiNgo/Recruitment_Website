package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job_seeker")
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long job_seeker_ID;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users users;

    @NotEmpty
    @Column(name = "first_name")
    private String first_name;

    @NotEmpty
    @Column(name ="last_name")
    private String last_name;

    @NotEmpty
    @Column(name ="phone_number")
    private String phone_number;

    @Column(name ="dob")
    private Date dob;

    @Column(name ="gender")
    private String gender;

    @Column(name ="address")
    private String address;

    @NotEmpty
    @Column(name ="city")
    private String city;

    @NotEmpty
    @Column(name ="province")
    private String province;

    @Column(name ="country")
    private String country;

    @Column(name ="summary")
    private String summary;

    @OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL)
    private Set<WorkExperience> workExperiences = new HashSet<>();

    @OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL)
    private Set<Education> educations = new HashSet<>();

    @OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL)
    private Set<Certificates> certificates = new HashSet<>();

    @OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL)
    private Set<JobSeekerSkills> jobSeekerSkills = new HashSet<>();

    @OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL)
    private Set<Languages> languages = new HashSet<>();

    public JobSeeker(){

    }

    public JobSeeker(Users users, String first_name, String last_name, String phone_number, Date dob, String gender, String address, String city, String province, String country, String summary) {
        this.users = users;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.summary = summary;
    }

    public Long getJob_seeker_ID() {
        return job_seeker_ID;
    }

    public void setJob_seeker_ID(Long job_seeker_ID) {
        this.job_seeker_ID = job_seeker_ID;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
