package com.interview.WiseStep.service;

import com.interview.WiseStep.entity.Booking;

public interface BookingService {
    public void saveBooking(Booking book) ; 
    public Booking findById(String id);
}
