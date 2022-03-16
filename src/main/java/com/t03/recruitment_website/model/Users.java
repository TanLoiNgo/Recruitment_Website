package com.t03.recruitment_website.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint
        (columnNames = "email"))
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_ID;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "pwd")
    @Size(min = 8, message = "password should have at least 8 characters")
    private String pwd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", nullable = false)
    private Date registration_date;

    @PrePersist
    private void onCreate(){
        registration_date = new Date();
    }

    @Column(name = "is_active")
    private Boolean is_active;

    @Column(name = "verification_code")
    private String verification_code;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(name = "user_ID", referencedColumnName = "user_ID",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_ID", referencedColumnName = "role_ID",
                            nullable = false, updatable = false)})
    private Collection< Role > roles;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<JobSeeker> jobSeekers = new HashSet<>();

    public Users() {
    }



    public Users(String email, String pwd ,Collection<Role> roles) {
        this.email = email;
        this.pwd = pwd;
        this.roles = roles;
    }


    public Long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Long user_ID) {
        this.user_ID = user_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_ID=" + user_ID +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", registration_date=" + registration_date +
                ", is_active=" + is_active +
                ", verification_code='" + verification_code + '\'' +
                ", roles=" + roles +
                '}';
    }
}
