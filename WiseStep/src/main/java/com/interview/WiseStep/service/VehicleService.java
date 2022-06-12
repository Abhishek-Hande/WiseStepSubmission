package com.interview.WiseStep.service;

import java.util.List;

import com.interview.WiseStep.Utils.BookingDto;
import com.interview.WiseStep.entity.Booking;
import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Vehicle;

public interface VehicleService {
    public List<Vehicle> getNearestVehicles(Locatioin userLocatioin);

    public Booking bookGivenvehicleID(BookingDto booking);
    public boolean validateBooking(String BookingId);

}
