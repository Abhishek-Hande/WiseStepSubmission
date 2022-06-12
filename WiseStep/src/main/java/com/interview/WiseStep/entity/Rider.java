package com.interview.WiseStep.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.interview.WiseStep.model.Locatioin;

public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    Locatioin curreLocatioin;
    public Rider() {
    }
    public Rider(String id, String name, Locatioin curreLocatioin, List<Booking> usersBooking) {
        this.id = id;
        this.name = name;
        this.curreLocatioin = curreLocatioin;
       // this.usersBooking = usersBooking;
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
    public Locatioin getCurreLocatioin() {
        return curreLocatioin;
    }
    public void setCurreLocatioin(Locatioin curreLocatioin) {
        this.curreLocatioin = curreLocatioin;
    }

    
}
