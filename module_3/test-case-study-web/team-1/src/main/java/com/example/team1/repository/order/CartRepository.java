package com.example.team1.repository.order;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.repository.Base;
import com.example.team1.repository.accounts.AccountRepository;
import com.example.team1.repository.accounts.IAccountRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartRepository implements ICartRepository {

    private static final String INSERT = "insert into carts (account_id, order_date, payment_status) values (?, ?, ?);";
    private static final String SELECT_LAST = "select * from carts order by cart_id desc limit 1;";
    private static final String SELECT_ALL = "select * from carts";
    private static final String DELETE = "delete from carts where cart_id = ?;";
    private static final String UPDATE = "update carts set " +
            "payment_date = ?, " +
            "payment_status = ? " +
            "where cart_id = ?";

    private static final IOrderDetailRepository orderDetailRepository = new OrderDetailRepository();

    private static final IAccountRepository accountRepository = new AccountRepository();

    @Override
    public void insertCart(Cart cart) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, cart.getAccounts().getId());
            preparedStatement.setString(2, cart.getOrderDate());
            preparedStatement.setInt(3, cart.getPaymentStatus());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cart selectCart(int id) {
        return selectAllCart().get(id);
    }

    @Override
    public Cart selectLastCart() {
        Cart cart = null;
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("cart_id");
                int accountId = resultSet.getInt("account_id");
                Accounts accounts = accountRepository.selectAccount(accountId);
                String orderDate = resultSet.getString("order_date");
                String paymentDate = resultSet.getString("payment_date");
                int paymentStatus = resultSet.getInt("payment_status");

                Map<Integer, OrderDetail> orderDetailList = orderDetailRepository.selectAllOrderByIdCart(id);

                cart = new Cart(id, accounts, orderDate, paymentDate, orderDetailList, paymentStatus);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    @Override
    public Map<Integer, Cart> selectAllCart() {
        Map<Integer, Cart> cartMap = new HashMap<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("cart_id");
                int accountId = resultSet.getInt("account_id");
                Accounts accounts = accountRepository.selectAccount(accountId);
                String orderDate = resultSet.getString("order_date");
                String paymentDate = resultSet.getString("payment_date");
                int paymentStatus = resultSet.getInt("payment_status");

                Map<Integer, OrderDetail> orderDetailList = orderDetailRepository.selectAllOrderByIdCart(id);

                cartMap.put(id, new Cart(id, accounts, orderDate, paymentDate, orderDetailList, paymentStatus));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartMap;
    }

    @Override
    public void deleteCart(int id) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCart(Cart cart) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, cart.getPaymentDate());
            preparedStatement.setInt(2, cart.getPaymentStatus());
            preparedStatement.setInt(3, cart.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
