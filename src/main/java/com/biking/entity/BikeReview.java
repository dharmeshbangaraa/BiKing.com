package com.biking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BikeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bikeName;
    private int bikeRating;
    private int styleAndDesign;
    private int reliability;
    private int comfort;
    private int serviceExperience;
    private int valueForMoney;
    private int performance;
    private String ownerMileage;
    private String reviewerName;
    private String reviewerEmail;
    private String reviewerRiddenKms;
    private String reviewTitle;
    private String reviewDescription;
}
