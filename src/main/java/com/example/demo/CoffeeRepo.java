package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepo extends JpaRepository<Coffee, Integer> {

}
