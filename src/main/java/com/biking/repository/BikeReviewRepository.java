package com.biking.repository;

import com.biking.entity.BikeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeReviewRepository extends JpaRepository<BikeReview, Long> {
    Optional<BikeReview> findByBikeName(String bikeName);
}
