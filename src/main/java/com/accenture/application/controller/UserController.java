package com.accenture.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.application.model.User;
import com.accenture.application.repository.UserRepository;


@RestController
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository repository;
	
	/*POST */
	@RequestMapping (value = "", method = RequestMethod.POST)
	public User creaUtente(@Valid @RequestBody User UserCollection){
		UserCollection.setId(ObjectId.get());
		repository.save(UserCollection);
		return UserCollection;
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

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User UserCollection = new User();
        modelAndView.addObject("user", UserCollection);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid @RequestBody User UserCollection, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = repository.findUserByEmail(UserCollection.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            repository.save(UserCollection);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }
		
	}
