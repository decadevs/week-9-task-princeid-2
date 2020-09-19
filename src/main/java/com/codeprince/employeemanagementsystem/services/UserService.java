package com.codeprince.employeemanagementsystem.services;

import com.codeprince.employeemanagementsystem.dto.UserRegistrationDto;
import com.codeprince.employeemanagementsystem.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
