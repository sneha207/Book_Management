package com.capgemini.bookmanagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.capgemini.bookmanagement.dto.UserRegistrationDto;
import com.capgemini.bookmanagement.entity.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
