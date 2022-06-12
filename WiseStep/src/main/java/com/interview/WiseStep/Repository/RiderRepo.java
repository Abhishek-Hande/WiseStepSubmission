package com.interview.WiseStep.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.WiseStep.entity.Rider;

public interface RiderRepo extends JpaRepository<Rider,String>{
    
}
