package com.interview.WiseStep.Utils;

import com.interview.WiseStep.model.Locatioin;

public class BookingDto {
    private String userId;
    private String vehicleId;
    private Locatioin endLocatioin;
    public BookingDto() {
    }
    public BookingDto(String userId, String vehicleId) {
        this.userId = userId;
        this.vehicleId = vehicleId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public Locatioin getEndLocatioin() {
        return endLocatioin;
    }
    public void setEndLocatioin(Locatioin endLocatioin) {
        this.endLocatioin = endLocatioin;
    }
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
    

}
