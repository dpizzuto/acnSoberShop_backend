package com.accenture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.model.*;

@RestController
public class UserController {

	@RequestMapping("/userAcn")
	public User adduser(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
			@RequestParam(value = "gender") String gender, @RequestParam(value = "age") int age,
			@RequestParam(value = "email") String email, @RequestParam(value = "password") String password)

	{
		User user = new User(name, surname, gender, age, email, password);
		return user;

	}

}
