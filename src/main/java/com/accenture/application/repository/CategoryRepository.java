package com.accenture.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.accenture.application.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

	List<Category> findAll();

	

}
