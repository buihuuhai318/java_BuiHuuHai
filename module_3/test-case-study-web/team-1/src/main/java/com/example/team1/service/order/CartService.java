package com.example.team1.service.order;

import com.example.team1.model.order.Cart;
import com.example.team1.repository.order.CartRepository;
import com.example.team1.repository.order.ICartRepository;

import java.util.Map;

public class CartService implements ICartService {

    private static final ICartRepository cartRepository = new CartRepository();

    @Override
    public void insertCart(Cart cart) {
        cartRepository.insertCart(cart);
    }

    @Override
    public Cart selectCart(int id) {
        return cartRepository.selectCart(id);
    }

    @Override
    public Map<Integer, Cart> selectAllCart() {
        return cartRepository.selectAllCart();
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteCart(id);
    }

    @Override
    public void updateCart(int id, Cart cart) {
        cartRepository.updateCart(id, cart);
    }

    @Override
    public Cart selectLastCart() {
        return cartRepository.selectLastCart();
    }
}
