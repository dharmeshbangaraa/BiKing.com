package com.biking.service.serviceImpl;

import com.biking.entity.BikeReview;
import com.biking.repository.BikeReviewRepository;
import com.biking.service.BikeReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BikeReviewServiceImpl implements BikeReviewService {

    private final BikeReviewRepository bikeReviewRepository;

    @Override
    public BikeReview publishNewReview(BikeReview bikeReview) {
        return this.bikeReviewRepository.save(bikeReview);
    }

    @Override
    public BikeReview fetchReviewByBikeName(String bikeName) {
        return this.bikeReviewRepository.findByBikeName(bikeName).orElse(null);
    }

    @Override
    public List<BikeReview> fetchAllReviews() {
        return this.bikeReviewRepository.findAll();
    }
}
