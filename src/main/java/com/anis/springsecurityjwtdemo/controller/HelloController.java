package com.anis.springsecurityjwtdemo.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anis.springsecurityjwtdemo.entity.Users;
import com.anis.springsecurityjwtdemo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HelloController {
	private final UserService userService;

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/login")
	public void login (@RequestBody Users user) {
		userService.verify(user);
	}
}
