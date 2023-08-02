package com.example.team1.repository.order;

import com.example.team1.model.order.OrderDetail;

import java.util.List;
import java.util.Map;

public interface IOrderDetailRepository {
    void insertOrder(OrderDetail orderDetail);

    OrderDetail selectOrderDetail(int cartId, int itemId);

    List<OrderDetail> selectAllOrder();

    Map<Integer, OrderDetail> selectAllOrderByIdCart(int id);

    void deleteOrder(int cartId, int itemId);

    void updateOrder(int id, OrderDetail orderDetail);
}
