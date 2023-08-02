package com.example.team1.repository.order;

import com.example.team1.model.order.Cart;

import java.util.List;
import java.util.Map;

public interface ICartRepository {
    void insertCart(Cart cart);

    Cart selectCart(int id);

    Cart selectLastCart();

    Map<Integer, Cart> selectAllCart();

    void deleteCart(int id);

    void updateCart(Cart cart);
}
