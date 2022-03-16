package com.t03.recruitment_website.dto;
import com.t03.recruitment_website.validate.FieldMatch;
import org.springframework.validation.annotation.Validated;

import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import java.util.Date;



@FieldMatch(first = "pwd", second = "confirmPassword", message = "The password fields must match")
@Validated
public class UserRegistrationDto {

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String pwd;

    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @AssertFalse
    private Boolean is_active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registration_date;

    @PrePersist
    private void onCreate(){
        registration_date = new Date();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }
}
