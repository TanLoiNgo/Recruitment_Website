package com.t03.recruitment_website.serviceImpl;

import com.t03.recruitment_website.dto.UserRegistrationDto;
import com.t03.recruitment_website.model.Role;
import com.t03.recruitment_website.model.Users;
import com.t03.recruitment_website.repositories.UserRepository;

import com.t03.recruitment_website.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users save(UserRegistrationDto registration) {
        Users user = new Users();
        user.setEmail(registration.getEmail());
        user.setPwd(passwordEncoder.encode(registration.getPwd()));
        user.setIs_active(false);
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPwd(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                .collect(Collectors.toList());
    }
}
