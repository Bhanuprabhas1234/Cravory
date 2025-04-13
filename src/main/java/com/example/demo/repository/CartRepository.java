package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Cart;

public interface CartRepository  extends CrudRepository<Cart, Integer> {

}
