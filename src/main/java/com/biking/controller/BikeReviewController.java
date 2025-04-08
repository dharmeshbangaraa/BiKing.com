package com.biking.controller;

import com.biking.entity.BikeReview;
import com.biking.service.BikeReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bike/review/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BikeReviewController {

    private final BikeReviewService bikeReviewService;

    @PostMapping("/")
    public ResponseEntity<BikeReview> publishReview(@RequestBody BikeReview bikeReview) {
        return ResponseEntity.ok(this.bikeReviewService.publishNewReview(bikeReview));
    }

    @GetMapping("/name")
    public ResponseEntity<BikeReview> fetchByBikeName(@RequestParam String bikeName) {
        return ResponseEntity.ok(this.bikeReviewService.fetchReviewByBikeName(bikeName));
    }

    @GetMapping("/")
    public ResponseEntity<List<BikeReview>> fetchAllReviews() {
        return ResponseEntity.ok(this.bikeReviewService.fetchAllReviews());
    }

    @GetMapping("/status")
    public ResponseEntity<String> reviewStatus() {
        return ResponseEntity.ok("up");
    }
}
