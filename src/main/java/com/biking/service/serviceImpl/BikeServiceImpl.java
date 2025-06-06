package com.biking.service.serviceImpl;


import com.biking.entity.Bike;
import com.biking.repository.BikeRepository;
import com.biking.service.BikeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
//    @CachePut(value = "BIKES", key = "'allBikes'")
    public List<Bike> uploadCSV(MultipartFile file) {
        List<Bike> parsedBikeList = parseCSV(file);
        this.bikeRepository.saveAll(parsedBikeList);
        return parsedBikeList;
    }

    @Override
//    @Cacheable(value = "BIKES", key = "'allBikes'")
    public List<Bike> getAllBikes() {
        log.info("getAllBikes() executed DB");
        return this.bikeRepository.findAll();
    }

    @Override
//    @CachePut(value = "BIKES", key = "'allBikes'") // Stores newly saved bike in cache
    public Bike addBike(Bike bike) {
        log.info("Bike saved to DB");
        return this.bikeRepository.save(bike);
    }

    @Override
//    @Cacheable(value = "BIKES", key = "'allBikes'") // Use a fixed key
    public Bike getAllBikesDummy() {
        log.info("getAllBikesDummy() executed DB");
        return this.bikeRepository.findAll().get(1);
    }

    @Override
//    @Cacheable(value = "BIKES", key = "#bikeName") // Cache each bike separately by name
    public Bike getByName(String bikeName) {
        log.info("getByName() executed DB");
        return this.bikeRepository.findByName(bikeName).orElse(null);
    }

    @Override
//    @Cacheable(value = "BIKES", key = "#brand") // Cache each bike separately by name
    public List<Bike> getByBrand(String brand) {
        log.info("getByBrand() executed DB");
        return this.bikeRepository.findAllByBrand(brand).orElse(List.of());
    }

    List<Bike> parseCSV(MultipartFile file) {
        List<Bike> bikeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            for (CSVRecord record : csvParser) {
                Bike bike = new Bike();
                bike.setName(record.get("bike name"));
                bike.setImage(record.get("image"));
                bike.setExPrice(record.get("exPrice"));
                bike.setOnRoadPrice(record.get("onRoadPrice"));
                bike.setEngineCapacity(record.get("engineCapacity"));
                bike.setMileageARAI(record.get("mileageARAI"));
                bike.setCategory(record.get("category"));
                bike.setBrand(record.get("brand"));
                bike.setFuelTankCapacity(record.get("fuelTankCapacity"));
                bike.setKerbWeight(record.get("kerbWeight"));
                bike.setPower(record.get("power"));
                bike.setTorque(record.get("torque"));
                bike.setInstrumentConsole(record.get("instrumentConsole"));
                bike.setGPS(record.get("GPS"));
                bike.setSpeedometer(record.get("speedometer"));
                bike.setOdometer(record.get("odometer"));
                bike.setFuelGauge(record.get("fuelGauge"));
                bike.setGearIndicator(record.get("gearIndicator"));
                bikeList.add(bike);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }
        return bikeList;
    }
}
