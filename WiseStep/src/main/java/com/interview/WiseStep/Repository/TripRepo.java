package com.interview.WiseStep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.WiseStep.entity.Trip;

public interface TripRepo extends JpaRepository<Trip,String> {
    
}
