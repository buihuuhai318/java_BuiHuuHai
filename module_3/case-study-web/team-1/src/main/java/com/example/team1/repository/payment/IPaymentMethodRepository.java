package com.example.team1.repository.payment;

import com.example.team1.model.payment.PaymentMethod;

import java.util.Map;

public interface IPaymentMethodRepository {
    Map<Integer, PaymentMethod> selectAll();
}
