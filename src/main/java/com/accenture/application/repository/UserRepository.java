package com.accenture.application.repository;

<<<<<<< HEAD
public interface UserRepository {

=======
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.application.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	
	User findByEmail(String email);

	User findUserByEmail(String email);
	
	List<User> findAll();
>>>>>>> changesGirolamo
}
