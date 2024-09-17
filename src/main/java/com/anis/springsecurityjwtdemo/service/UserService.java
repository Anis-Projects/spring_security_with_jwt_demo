package com.anis.springsecurityjwtdemo.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.anis.springsecurityjwtdemo.entity.Users;
import com.anis.springsecurityjwtdemo.repository.UserRepository;
import com.anis.springsecurityjwtdemo.security.jwt.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final AuthenticationManager authenticationManager;
	private final JWTService jwtService;

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public void verify(Users user)  {
		Authentication authentication=
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		if (authentication.isAuthenticated()) {
			jwtService.generateToken(user.getUsername());
		}
	}
}
