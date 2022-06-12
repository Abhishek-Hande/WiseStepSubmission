package com.interview.WiseStep.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.WiseStep.Repository.VehicalRepo;
import com.interview.WiseStep.Utils.BookingDto;
import com.interview.WiseStep.Utils.BookingStatus;
import com.interview.WiseStep.Utils.PaymentStatus;
import com.interview.WiseStep.Utils.TripStatus;
import com.interview.WiseStep.entity.Booking;
import com.interview.WiseStep.entity.Outlet;
import com.interview.WiseStep.entity.Rider;
import com.interview.WiseStep.entity.Scooty_Vehicle;
import com.interview.WiseStep.entity.Trip;
import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Payment;
import com.interview.WiseStep.model.Vehicle;

@Service
public class VehicleServiceimpl implements VehicleService{
    final int PER_KM_CHARGES=8;
    final int VALID_BOOKING_DURATION_IN_MINUTES=120;
    @Autowired
    VehicalRepo vehicalRepo ;
    @Autowired 
    OutletServiceImpl outletServiceImpl; 
    @Autowired
    RiderServiceImpl riderServiceImpl;
    @Autowired
    BookingServiceImpl bookingServiceImpl; 
    @Autowired
    TripServiceImpl tripServiceImpl;
    debitCardPaymentImpl debitCardPayment; 
    public List<Vehicle> getNearestVehicles(Locatioin userLocatioin){
        List<Outlet> allOutlets=outletServiceImpl.ListAllOutlets();
        Double distanceFromuserToOutlet;
        Outlet nearestAvailableOutlet=null;
        double tempDistance=0;
        for (Outlet outlet : allOutlets) {
            distanceFromuserToOutlet=Math.sqrt(Math.pow(outlet.getOutletLocation().getX_cordinate()-userLocatioin.getX_cordinate(), 2)
                                             + Math.pow(outlet.getOutletLocation().getY_cordinate()-userLocatioin.getY_cordinate(), 2));
        distanceFromuserToOutlet=(distanceFromuserToOutlet < 0)?-1*distanceFromuserToOutlet:distanceFromuserToOutlet;
        if(tempDistance<distanceFromuserToOutlet && outlet.getCurrentVehicalCount()>0){
            nearestAvailableOutlet=outlet;
            tempDistance=distanceFromuserToOutlet;
        }

       
    }
    return nearestAvailableOutlet.getVehical().stream().filter(v->{return v.isAvailable()==true;}).collect(Collectors.toList()); 
 }
    @Override
    public Booking bookGivenvehicleID(BookingDto bookingDto){
        Optional<Scooty_Vehicle> vehicale=vehicalRepo.findById(bookingDto.getVehicleId());
        Scooty_Vehicle bookedvehiclee=vehicale.orElse(null);
        Rider rideUser=riderServiceImpl.findById(bookingDto.getUserId());
        if(bookedvehiclee!=null){
            bookedvehiclee.setAvailable(false);
        }
        
       double ridingDistance=Math.sqrt(Math.pow(rideUser.getCurreLocatioin().getX_cordinate()-bookingDto.getEndLocatioin().getX_cordinate(), 2)
                           + Math.pow(rideUser.getCurreLocatioin().getY_cordinate()-bookingDto.getEndLocatioin().getY_cordinate(), 2));
         
        double paymentAmount=PER_KM_CHARGES*ridingDistance;

        debitCardPayment.setPaymentStatus(PaymentStatus.INITIALIZED);
        debitCardPayment.makePayment(paymentAmount);
        debitCardPayment.setPaymentStatus(PaymentStatus.SUCCEED);

        Trip trip=new Trip(rideUser.getCurreLocatioin(),bookingDto.getEndLocatioin(), bookedvehiclee, rideUser, TripStatus.INITIALIZED);

        Booking resultedBooking=new Booking( debitCardPayment, rideUser, LocalDateTime.now(), BookingStatus.INPREOGRESS, bookedvehiclee,trip);
        bookingServiceImpl.saveBooking(resultedBooking);

        return resultedBooking;
    }
    @Override
    public boolean validateBooking(String BookingId) {
        // TODO Auto-generated method stub
        Booking booked=bookingServiceImpl.findById(BookingId);
        Boolean isValidBooking=false;
        if(VALID_BOOKING_DURATION_IN_MINUTES > booked.getBookingTime().getMinute()-LocalDateTime.now().getMinute()){
            isValidBooking=true;
        }
        return isValidBooking;
    }
    @Override
    public Boolean endTrip(String tripId) {
    Boolean isTripSuccess=false;
       Trip trip= tripServiceImpl.findTrip(tripId);
       if(trip!=null){
       trip.setTripStatus(TripStatus.COMPLETED);
       tripServiceImpl.save(trip);
       isTripSuccess=true;
       }
        return isTripSuccess;
    }
}