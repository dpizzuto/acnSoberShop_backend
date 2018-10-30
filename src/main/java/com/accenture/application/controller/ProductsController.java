package com.accenture.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.application.model.Products;
import com.accenture.application.repository.ProductsRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductsController {

	@Autowired
	ProductsRepository repository;
	@Autowired
	MongoTemplate mongoTemplate;

	/* GET */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Products> getAllProducts() {
		return (List<Products>) repository.findAll();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List <Products> products (@RequestParam(value="type") String type) {
	Query query = new Query();
	query.addCriteria(Criteria.where("type").regex("^"+type));
	List<Products> users = mongoTemplate.find(query,Products.class);
	return users;
	}
}
