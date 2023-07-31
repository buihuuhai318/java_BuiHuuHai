package com.example.team1.repository.order;

import com.example.team1.model.item.Items;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.repository.Base;
import com.example.team1.repository.item.IItemRepository;
import com.example.team1.repository.item.ItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepository implements IOrderDetailRepository {

    private static final String INSERT = "insert into order_details (cart_id, item_id, detail_quantity, detail_price_total) values (?, ?, ?, ?);";
    private static final String SELECT_BY_CART_ID = "select * from order_details where cart_id = ?;";
    private static final String SELECT_ALL = "select * from order_details";
    private static final String DELETE = "delete from order_details where cart_id = ? and item_id = ?;";
    private static final String UPDATE = "update order_details set " +
            "detail_quantity = ?, " +
            "detail_price_total = ? " +
            "where cart_id = ? and item_id = ?;";

    private static final IItemRepository itemRepository = new ItemRepository();


    @Override
    public void insertOrder(OrderDetail orderDetail) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, orderDetail.getId());
            preparedStatement.setInt(2, orderDetail.getItems().getId());
            preparedStatement.setInt(3, orderDetail.getQuantity());
            preparedStatement.setInt(4, orderDetail.getPrice());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderDetail selectOrderDetail(int cartId, int itemId) {
        for (OrderDetail order : selectAllOrder()) {
            if (order.getItems().getId() == itemId && order.getId() == cartId) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<OrderDetail> selectAllOrder() {
        List<OrderDetail> detailList = new ArrayList<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("cart_id");
                int itemId = resultSet.getInt("item_id");
                Items items = itemRepository.selectItem(itemId);
                int quantity = resultSet.getInt("detail_quantity");
                int priceTotal = resultSet.getInt("detail_price_total");

                detailList.add(new OrderDetail(id, items, quantity, priceTotal));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return detailList;
    }

    @Override
    public List<OrderDetail> selectAllOrderByIdCart(int id) {
        List<OrderDetail> detailList = new ArrayList<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cartId = resultSet.getInt("cart_id");

                if (cartId == id) {
                    int itemId = resultSet.getInt("item_id");
                    Items items = itemRepository.selectItem(itemId);
                    int quantity = resultSet.getInt("detail_quantity");
                    int priceTotal = resultSet.getInt("detail_price_total");
                    detailList.add(new OrderDetail(id, items, quantity, priceTotal));
                }
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return detailList;
    }

    @Override
    public void deleteOrder(int cartId, int itemId) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, itemId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateOrder(int id, OrderDetail orderDetail) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setInt(2, orderDetail.getPrice());
            preparedStatement.setInt(3, orderDetail.getId());
            preparedStatement.setInt(4, orderDetail.getItems().getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
