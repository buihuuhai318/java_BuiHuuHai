package com.example.team1.repository.payment;

import com.example.team1.model.payment.PaymentMethod;

import java.util.Map;

public interface IPaymentMethodRepository {
    Map<Integer, PaymentMethod> selectAll();

    Map<Integer, PaymentMethod> selectAllAvailable();

    void setAvailableMethod(int id, boolean available);

    PaymentMethod getPayment(int id);
}
