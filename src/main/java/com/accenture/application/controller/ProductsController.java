package com.accenture.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.application.model.Products;
import com.accenture.application.repository.ProductsRepository;


@RestController
public class ProductsController {
	
	@Autowired 
	ProductsRepository repo;
	
	@Autowired
	public MongoTemplate mongoTemplate;

	/* GET */
	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public List<Products> getAllProducts(){
		return (List<Products>) repo.findAll();
	}
	
	/*@RequestMapping(value = "/AllProducts", method=RequestMethod.GET)
	public Iterable<Products> getAllProducts(){
		return repo.findAll();
	}*/
}
