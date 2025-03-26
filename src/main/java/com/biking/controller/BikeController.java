package com.biking.controller;


import com.biking.entity.Bike;
import com.biking.service.BikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bike")
@AllArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @PostMapping("/")
    public ResponseEntity<List<Bike>> uploadBikesFromCSV(@RequestParam("file")MultipartFile file) {
        if(file.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(this.bikeService.uploadCSV(file));
    }
}
