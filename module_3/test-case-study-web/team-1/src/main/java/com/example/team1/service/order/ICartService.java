package com.example.team1.service.order;

import com.example.team1.model.order.Cart;

import java.util.Map;

public interface ICartService {
    void insertCart(Cart cart);

    Cart selectCart(int id);

    Map<Integer, Cart> selectAllCart();

    void deleteCart(int id);

    void updateCart(Cart cart);

    Cart selectLastCart();
}
