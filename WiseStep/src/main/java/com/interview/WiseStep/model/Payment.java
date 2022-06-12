package com.interview.WiseStep.model;

import com.interview.WiseStep.Utils.PaymentStatus;

public interface Payment {
    boolean makePayment(Double paymentAmount);
    PaymentStatus getPaymentStatus();
    PaymentStatus setPaymentStatus(PaymentStatus status);
}
