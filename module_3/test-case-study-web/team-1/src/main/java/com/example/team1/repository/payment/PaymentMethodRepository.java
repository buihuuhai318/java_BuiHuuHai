package com.example.team1.repository.payment;

import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PaymentMethodRepository implements IPaymentMethodRepository {

    private static final String SELECT_ALL = "select * from payment_method";
    private static final String SELECT = "select * from payment_method where payment_id = ?";
    private static final String SELECT_ALL_AVAILABLE = "select * from payment_method where payment_available = 0";
    private static final String SET_AVAILABLE = "update payment_method set payment_available = ? where payment_id = ?";

    @Override
    public Map<Integer, PaymentMethod> selectAll() {
        Map<Integer, PaymentMethod> paymentMethodMap = new HashMap<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("payment_id");
                String name = resultSet.getString("payment_name");
                int available = resultSet.getInt("payment_available");
                paymentMethodMap.put(id, new PaymentMethod(id, name, available));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethodMap;
    }

    @Override
    public Map<Integer, PaymentMethod> selectAllAvailable() {
        Map<Integer, PaymentMethod> paymentMethodMap = new HashMap<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AVAILABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("payment_id");
                String name = resultSet.getString("payment_name");
                int available = resultSet.getInt("payment_available");
                paymentMethodMap.put(id, new PaymentMethod(id, name, available));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethodMap;
    }

    @Override
    public void setAvailableMethod(int id, boolean available) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SET_AVAILABLE);
            if (available) {
                preparedStatement.setInt(1, 0);
            } else {
                preparedStatement.setInt(1, 1);
            }
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaymentMethod getPayment(int id) {
        PaymentMethod paymentMethod = new PaymentMethod();
        Connection connection = Base.getConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("payment_name");
                int available = resultSet.getInt("payment_available");
                paymentMethod.setId(id);
                paymentMethod.setName(name);
                paymentMethod.setAvailable(available);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethod;
    }
}
