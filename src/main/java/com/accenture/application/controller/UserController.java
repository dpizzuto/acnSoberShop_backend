package com.accenture.application.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.application.model.User;
import com.accenture.application.repository.UserRepository;
import com.accenture.application.validator.UserValidator;


@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository repository;

	@Autowired
	UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("UserCollection", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid @RequestBody User UserCollection, BindingResult bindingResult, Model model) {
		userValidator.validate(UserCollection, bindingResult);

		if (bindingResult.hasErrors()) {
			return "User exists";
		}

		repository.save(UserCollection);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		List<User> user = repository.findAll();
		for (User u : user) {
			if (email.equals(u.getEmail()) && password.equals(u.getPassword()))
				return "ok";
		}
		return "error ";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	/* GET */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUser() {
		return (List<User>) repository.findAll();
	}

	/* GET */
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable("email") String email) {
		return repository.findByEmail(email);
	}
}
