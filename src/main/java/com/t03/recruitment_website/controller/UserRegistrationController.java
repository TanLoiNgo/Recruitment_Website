package com.t03.recruitment_website.controller;

import com.t03.recruitment_website.dto.UserRegistrationDto;
import com.t03.recruitment_website.model.Users;
import com.t03.recruitment_website.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){

        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){

        return "registration";
    }

    @PostMapping
    public  String registerUserAccount(@Valid @ModelAttribute("user")UserRegistrationDto registrationDto, BindingResult result){
        Users existing = userService. findByEmail(registrationDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(registrationDto);

        return  "redirect:/registration?success";
    }
}
