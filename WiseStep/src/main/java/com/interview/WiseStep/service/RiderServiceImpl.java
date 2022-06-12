package com.interview.WiseStep.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.WiseStep.Repository.RiderRepo;
//import com.interview.WiseStep.Repository.RiderRepo.*;
import com.interview.WiseStep.entity.Rider;

public class RiderServiceImpl implements RiderService {
    @Autowired
    RiderRepo riderRepo; 
    @Override
    public Rider findById(String riderId) {
       
        return riderRepo.findById(riderId).orElse(null);
    }
    
}
