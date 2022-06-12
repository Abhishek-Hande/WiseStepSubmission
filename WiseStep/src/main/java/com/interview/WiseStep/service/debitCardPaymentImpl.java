package com.interview.WiseStep.service;

import com.interview.WiseStep.Utils.PaymentStatus;
import com.interview.WiseStep.model.Payment;

public class debitCardPaymentImpl implements Payment {
    private Double currentDebitCardBalance=10000.0d;
    private PaymentStatus paymentStatus;
   
    public debitCardPaymentImpl(Double currentDebitCardBalance, PaymentStatus paymentStatus) {
    this.currentDebitCardBalance = currentDebitCardBalance;
    this.paymentStatus = paymentStatus;
}
    @Override
    public boolean makePayment(Double paymentAmount) {
        if(currentDebitCardBalance>paymentAmount){
            currentDebitCardBalance=currentDebitCardBalance-paymentAmount;
            return true;
        }
        return false;
    }
    @Override
    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }
    @Override
    public PaymentStatus setPaymentStatus(PaymentStatus status) {
        // TODO Auto-generated method stub
        this.paymentStatus=status;
        return null;
    }
    
}
