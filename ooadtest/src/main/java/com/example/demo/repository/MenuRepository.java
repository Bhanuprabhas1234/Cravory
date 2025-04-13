package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
}
