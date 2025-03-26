package com.biking.controller;


import com.biking.entity.Bike;
import com.biking.service.BikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bike")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BikeController {

    private final BikeService bikeService;

    @PostMapping("/")
    public ResponseEntity<List<Bike>> uploadBikesFromCSV(@RequestParam("file")MultipartFile file) {
        if(file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(this.bikeService.uploadCSV(file));
    }

    @GetMapping("/")
    public ResponseEntity<List<Bike>> fetchAllBikes() {
        return ResponseEntity.ok(this.bikeService.getAllBikes());
    }

    @GetMapping("/name")
    public ResponseEntity<Bike> fetchBikeByName(@RequestParam String bikeName) {
        return ResponseEntity.ok(this.bikeService.getByName(bikeName));
    }
}
