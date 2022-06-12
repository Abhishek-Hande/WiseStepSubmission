package com.interview.WiseStep.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.WiseStep.Repository.TripRepo;
import com.interview.WiseStep.entity.Trip;

public class TripServiceImpl implements TripService {
    @Autowired
    TripRepo tripRepo; 
    public Trip findTrip(String tripId) {
        return tripRepo.findById(tripId).orElse(null);
    }
    public void save(Trip trip) {
        tripRepo.save(trip);
    }
    
}
