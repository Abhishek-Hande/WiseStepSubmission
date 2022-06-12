package com.interview.WiseStep.service;

import com.interview.WiseStep.Utils.PaymentStatus;

public interface PaymentService {
    boolean makePayment(Double paymentAmount);
    PaymentStatus getPaymentStatus();
    PaymentStatus setPaymentStatus(String status);
}
