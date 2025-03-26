package com.biking.repository;

import com.biking.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
    Optional<Bike> findByName(String bikeName);
}
