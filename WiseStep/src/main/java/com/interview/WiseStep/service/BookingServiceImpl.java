package com.interview.WiseStep.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.WiseStep.Repository.BookingRepo;
import com.interview.WiseStep.entity.Booking;

public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;
    public void saveBooking(Booking book){
        bookingRepo.save(book);

   }
   public Booking findById(String id){
    return bookingRepo.findById(id).orElse(null);

   }
}
