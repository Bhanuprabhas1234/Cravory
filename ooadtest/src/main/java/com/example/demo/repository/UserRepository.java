package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
