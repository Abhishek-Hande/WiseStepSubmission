package com.interview.WiseStep.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.interview.WiseStep.Utils.BookingStatus;
import com.interview.WiseStep.model.Payment;
import com.interview.WiseStep.model.Vehicle;

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
   
    private Payment payment;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id")
    private Rider rider;
    private LocalDateTime BookingTime;
    private BookingStatus BookingStatus;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;
    public Booking() {
    }
 
    
    public Booking(  Payment payment, Rider rider, LocalDateTime bookingTime,
            com.interview.WiseStep.Utils.BookingStatus bookingStatus, Vehicle vehicle, Trip trip) {
        
       
        this.payment = payment;
        this.rider = rider;
        BookingTime = bookingTime;
        BookingStatus = bookingStatus;
        this.vehicle = vehicle;
        this.trip = trip;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    public Rider getRider() {
        return rider;
    }
    public void setRider(Rider rider) {
        this.rider = rider;
    }
    public LocalDateTime getBookingTime() {
        return BookingTime;
    }
    public void setBookingTime(LocalDateTime bookingTime) {
        BookingTime = bookingTime;
    }
    public BookingStatus getBookingStatus() {
        return BookingStatus;
    }
    public void setBookingStatus(BookingStatus bookingStatus) {
        BookingStatus = bookingStatus;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public Trip getTrip() {
        return trip;
    }


    public void setTrip(Trip trip) {
        this.trip = trip;
    }
  
   
}
