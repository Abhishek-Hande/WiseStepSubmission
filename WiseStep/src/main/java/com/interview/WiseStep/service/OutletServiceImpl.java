package com.interview.WiseStep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.WiseStep.Repository.OutletRepo;
import com.interview.WiseStep.entity.Outlet;

@Service
public class OutletServiceImpl implements OutletService {
   @Autowired
   OutletRepo outletRepo; 
   public List<Outlet> ListAllOutlets(){
    return outletRepo.findAll();
   }
}
