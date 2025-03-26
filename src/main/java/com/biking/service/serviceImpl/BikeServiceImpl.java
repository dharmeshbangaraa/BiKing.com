package com.biking.service.serviceImpl;


import com.biking.entity.Bike;
import com.biking.repository.BikeRepository;
import com.biking.service.BikeService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
    public List<Bike> uploadCSV(MultipartFile file) {
        List<Bike> parsedBikeList = parseCSV(file);
        this.bikeRepository.saveAll(parsedBikeList);
        return parsedBikeList;
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
