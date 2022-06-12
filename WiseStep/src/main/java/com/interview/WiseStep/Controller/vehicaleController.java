package com.interview.WiseStep.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.WiseStep.Utils.BookingDto;
import com.interview.WiseStep.entity.Booking;
import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Vehicle;
import com.interview.WiseStep.service.VehicleService;

@RestController
@RequestMapping("/vehicale")
public class vehicaleController {
    @Autowired
    VehicleService vehicleService;
    @PostMapping("/getNearestOutletsVehicles")
   public ResponseEntity<List<Vehicle>> findVehiclesFromNearestOutlet(@RequestBody Locatioin userLocation){
   List<Vehicle> nearestOutletsVehicles=vehicleService.getNearestVehicles(userLocation);
    return new  ResponseEntity<>(nearestOutletsVehicles,HttpStatus.OK);
   }

   @PostMapping("/bookVehicle")
   public ResponseEntity<Booking> bookVehicle(@RequestBody BookingDto Booking){
    Booking bookingResult=vehicleService.bookGivenvehicleID(Booking);
    return new  ResponseEntity<>(bookingResult,HttpStatus.OK);
   }

   @PostMapping("/isBookingVallid")
   public ResponseEntity<Boolean> isBookingVallid(@RequestBody String BookingId){
    Boolean isValidBooking=vehicleService.validateBooking(BookingId);
    return new  ResponseEntity<>(isValidBooking,HttpStatus.OK);
   }
   @PostMapping("/endTrip")
   public ResponseEntity<Boolean> endTrip(@RequestBody String TripId){
    Boolean isValidBooking=vehicleService.endTrip(TripId);
    return new  ResponseEntity<>(isValidBooking,HttpStatus.OK);
   }

}
