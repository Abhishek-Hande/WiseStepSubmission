package com.interview.WiseStep.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.catalina.User;

import com.interview.WiseStep.Utils.TripStatus;
import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Vehicle;
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Locatioin tripStartLocation;
    private Locatioin tripEndLacation;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rider_id")
    private Rider tripRider;
    private TripStatus tripStatus;
    public Trip() {
    }
    public Trip( Locatioin tripStartLocation, Locatioin tripEndLacation, Vehicle vehicle,
            Rider tripRider, TripStatus tripStatus) {
      
        this.tripStartLocation = tripStartLocation;
        this.tripEndLacation = tripEndLacation;
        this.vehicle = vehicle;
        this.tripRider = tripRider;
        this.tripStatus = tripStatus;
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
    public Locatioin getTripStartLocation() {
        return tripStartLocation;
    }
    public void setTripStartLocation(Locatioin tripStartLocation) {
        this.tripStartLocation = tripStartLocation;
    }
    public Locatioin getTripEndLacation() {
        return tripEndLacation;
    }
    public void setTripEndLacation(Locatioin tripEndLacation) {
        this.tripEndLacation = tripEndLacation;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Rider getTripRider() {
        return tripRider;
    }
    public void setTripRider(Rider tripRider) {
        this.tripRider = tripRider;
    }
    public TripStatus getTripStatus() {
        return tripStatus;
    }
    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }
    
}
