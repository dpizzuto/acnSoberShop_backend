package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.model.Products;
import com.accenture.repository.ProductsRepository;


@RestController
public class ProductsController {
	
	@Autowired 
	private ProductsRepository repo;
	
	@Autowired
	public MongoTemplate mongoTemplate;
	
	//GET
	public List<Products> findAll(){
		List<Products> products = (List<Products>) repo.findAll();
		return products;
	}
	
	/*@RequestMapping(value = "/", method=RequestMethod.GET)
	public List<Products> getAllProducts(){
		return repo.findAll();
	}*/
	
	@RequestMapping(value = "/AllProducts", method=RequestMethod.GET)
	public Iterable<Products> getAllProducts(){
		return repo.findAll();
	}
}
