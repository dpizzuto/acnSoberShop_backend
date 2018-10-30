package com.accenture.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.accenture.application.model.Products;

public interface ProductsRepository extends MongoRepository<Products, String> {

	List<Products> findAll();

	

}
