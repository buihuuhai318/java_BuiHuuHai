package com.example.team1.service.order;

import com.example.team1.model.order.OrderDetail;
import com.example.team1.repository.order.IOrderDetailRepository;
import com.example.team1.repository.order.OrderDetailRepository;

import java.util.List;

public class OrderDetailService implements IOrderDetailService {

    private static final IOrderDetailRepository orderDetailRepository = new OrderDetailRepository();

    @Override
    public void insertOrder(OrderDetail orderDetail) {
        orderDetailRepository.insertOrder(orderDetail);
    }

    @Override
    public OrderDetail selectOrderDetail(int cartId, int itemId) {
        return orderDetailRepository.selectOrderDetail(cartId, itemId);
    }

    @Override
    public List<OrderDetail> selectAllOrder() {
        return orderDetailRepository.selectAllOrder();
    }

    @Override
    public List<OrderDetail> selectAllOrderByIdCart(int id) {
        return orderDetailRepository.selectAllOrderByIdCart(id);
    }

    @Override
    public void deleteOrder(int cartId, int itemId) {
        orderDetailRepository.deleteOrder(cartId, itemId);
    }

    @Override
    public void updateOrder(int id, OrderDetail orderDetail) {
        orderDetailRepository.updateOrder(id, orderDetail);
    }
}
