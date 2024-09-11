package com.alpha.backpacker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.backpacker.entity.City;
import com.alpha.backpacker.entity.Userr;

public interface CityRepository extends JpaRepository<City, Integer> {
}
