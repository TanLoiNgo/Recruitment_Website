package com.t03.recruitment_website.services;

import com.t03.recruitment_website.dto.UserRegistrationDto;
import com.t03.recruitment_website.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users findByEmail(String email);

    Users save(UserRegistrationDto registrationDto);
}
