package com.interview.WiseStep.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.interview.WiseStep.model.Locatioin;
import com.interview.WiseStep.model.Vehicle;
@Entity
public class Scooty_Vehicle implements Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private boolean isAvailable;
    private Locatioin curreLocatioin;
    public Scooty_Vehicle() {
    }
    public Scooty_Vehicle(String id, String name, boolean isAvailable, Locatioin curreLocatioin) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
        this.curreLocatioin = curreLocatioin;
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
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public Locatioin getCurreLocatioin() {
        return curreLocatioin;
    }
    public void setCurreLocatioin(Locatioin curreLocatioin) {
        this.curreLocatioin = curreLocatioin;
    }
    
}
