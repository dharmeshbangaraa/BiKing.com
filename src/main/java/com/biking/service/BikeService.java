package com.biking.service;

import com.biking.entity.Bike;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BikeService {

    List<Bike> uploadCSV(MultipartFile file);
    List<Bike> getAllBikes();
    Bike getByName(String bikeName);
    List<Bike> getByBrand(String brand);
}
