package com.example.team1.repository.payment;

import com.example.team1.model.order.Cart;
import com.example.team1.model.payment.Bill;
import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.repository.Base;
import com.example.team1.repository.order.CartRepository;
import com.example.team1.repository.order.ICartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillRepository implements IBillRepository {

    private static final String INSERT = "insert into bill (cart_id, payment_id, bill_date, total_quantity, total_price, phone, address, payment_status) values (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_BY_ID = "select * from bill where bill_id = ?;";
    private static final String SELECT_ALL = "select * from bill order by bill_id desc;";
    private static final String SELECT_ALL_BY_ACC = "select * from bill " +
            "join carts on carts.cart_id = bill.cart_id " +
            "join accounts on carts.account_id = accounts.account_id " +
            "where accounts.account_id = ? " +
            "order by bill_id desc";

    private static final String SET_PURCHASED = "update bill set payment_status = ? where bill_id = ?";
    private static final ICartRepository cartRepository = new CartRepository();
    private static final IPaymentMethodRepository paymentMethodRepository = new PaymentMethodRepository();

    @Override
    public void insertBill(Bill bill) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, bill.getCart());
            preparedStatement.setInt(2, bill.getPaymentMethod().getId());
            preparedStatement.setString(3, bill.getDate());
            preparedStatement.setInt(4, bill.getTotalQuantity());
            preparedStatement.setInt(5, bill.getTotalPrice());
            preparedStatement.setString(6, bill.getPhone());
            preparedStatement.setString(7, bill.getAddress());
            preparedStatement.setInt(8, bill.getPaymentStatus());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bill selectBill(int id) {
        Connection connection = Base.getConnection();
        Bill bill = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cartId = resultSet.getInt("cart_id");
                int paymentId = resultSet.getInt("payment_id");
                PaymentMethod paymentMethod = paymentMethodRepository.selectAll().get(paymentId);
                String billDate = resultSet.getString("bill_date");
                int totalQuantity = resultSet.getInt("total_quantity");
                int totalPrice = resultSet.getInt("total_price");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int paymentStatus = resultSet.getInt("payment_status");
                bill = new Bill(id, cartId, paymentMethod, billDate, totalQuantity, totalPrice, phone, address, paymentStatus);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bill;
    }

    @Override
    public List<Bill> selectAllByAccount(int id) {
        List<Bill> billList = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_ACC);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int billId = resultSet.getInt("bill_id");
                int cartId = resultSet.getInt("cart_id");
                int paymentId = resultSet.getInt("payment_id");
                PaymentMethod paymentMethod = paymentMethodRepository.selectAll().get(paymentId);
                String billDate = resultSet.getString("bill_date");
                int totalQuantity = resultSet.getInt("total_quantity");
                int totalPrice = resultSet.getInt("total_price");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int paymentStatus = resultSet.getInt("payment_status");
                billList.add(new Bill(billId, cartId, paymentMethod, billDate, totalQuantity, totalPrice, phone, address, paymentStatus));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billList;
    }

    @Override
    public List<Bill> selectAll() {
        List<Bill> billList = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int billId = resultSet.getInt("bill_id");
                int cartId = resultSet.getInt("cart_id");
                int paymentId = resultSet.getInt("payment_id");
                PaymentMethod paymentMethod = paymentMethodRepository.selectAll().get(paymentId);
                String billDate = resultSet.getString("bill_date");
                int totalQuantity = resultSet.getInt("total_quantity");
                int totalPrice = resultSet.getInt("total_price");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                int paymentStatus = resultSet.getInt("payment_status");
                billList.add(new Bill(billId, cartId, paymentMethod, billDate, totalQuantity, totalPrice, phone, address, paymentStatus));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billList;
    }

    @Override
    public void setPurchase(int id, boolean available) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement;
            if (available) {
                preparedStatement = connection.prepareStatement(SET_PURCHASED);
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, id);
            } else {
                preparedStatement = connection.prepareStatement(SET_PURCHASED);
                preparedStatement.setInt(1, 0);
                preparedStatement.setInt(2, id);
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
