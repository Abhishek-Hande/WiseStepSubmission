package com.interview.WiseStep.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Vehicle;

@Entity
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private Locatioin outletLocation;
    private int CurrentVehicalCount;
    @OneToMany(mappedBy = "Outlet",fetch = FetchType.LAZY,
    cascade = CascadeType.ALL )
    List<Vehicle> vehical;
    public Outlet() {
    }
    public Outlet(String id, String name, Locatioin outletLocation, int currentVehicalCount, List<Vehicle> vehical) {
        this.id = id;
        this.name = name;
        this.outletLocation = outletLocation;
        CurrentVehicalCount = currentVehicalCount;
        this.vehical = vehical;
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
    public Locatioin getOutletLocation() {
        return outletLocation;
    }
    public void setOutletLocation(Locatioin outletLocation) {
        this.outletLocation = outletLocation;
    }
    public int getCurrentVehicalCount() {
        return CurrentVehicalCount;
    }
    public void setCurrentVehicalCount(int currentVehicalCount) {
        CurrentVehicalCount = currentVehicalCount;
    }
    public List<Vehicle> getVehical() {
        return vehical;
    }
    public void setVehical(List<Vehicle> vehical) {
        this.vehical = vehical;
    }
    

}
