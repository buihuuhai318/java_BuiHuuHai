package com.example.team1.service.order;

import com.example.team1.model.order.OrderDetail;

import java.util.Map;

public interface IOrderDetailService {
    void insertOrder(OrderDetail orderDetail);

    OrderDetail selectOrderDetail(int cartId, int itemId);

    Map<Integer, OrderDetail> selectAllOrderByIdCart(int id);

    void deleteOrder(int cartId, int itemId);

    void updateOrder(int id, OrderDetail orderDetail);
}
