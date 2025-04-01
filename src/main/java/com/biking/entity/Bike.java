package com.biking.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private String exPrice;
    private String onRoadPrice;
    private String engineCapacity;
    private String mileageARAI;
    private String category;
    private String brand;
    private String fuelTankCapacity;
    private String kerbWeight;
    private String power;
    private String torque;
    private String instrumentConsole;
    private String GPS;
    private String speedometer;
    private String odometer;
    private String fuelGauge;
    private String gearIndicator;
}
