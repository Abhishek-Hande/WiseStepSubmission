package com.interview.WiseStep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.WiseStep.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking,String> {
    
}
