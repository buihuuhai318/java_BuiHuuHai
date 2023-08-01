package com.example.team1.service.payment;

import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.repository.payment.IPaymentMethodRepository;
import com.example.team1.repository.payment.PaymentMethodRepository;

import java.util.Map;

public class PaymentMethodService implements IPaymentMethodService {

    private static final IPaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();

    @Override
    public Map<Integer, PaymentMethod> selectAll() {
        return paymentMethodRepository.selectAll();
    }
}
