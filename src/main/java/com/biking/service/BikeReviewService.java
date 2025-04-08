package com.biking.service;

import com.biking.entity.BikeReview;

import java.util.List;

public interface BikeReviewService {

    BikeReview publishNewReview(BikeReview bikeReview);
    BikeReview fetchReviewByBikeName(String bikeName);
    List<BikeReview> fetchAllReviews();

}
