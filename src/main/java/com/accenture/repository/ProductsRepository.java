package com.accenture.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.accenture.model.Products;



@RepositoryRestResource(collectionResourceRel = "AcnSoberShop", path="postmanQuery")
public interface ProductsRepository extends MongoRepository<Products, String>{
	
	List<Products> findAll();
	
	List <Products> findByName(@Param(value = "productName") String productName);

}
