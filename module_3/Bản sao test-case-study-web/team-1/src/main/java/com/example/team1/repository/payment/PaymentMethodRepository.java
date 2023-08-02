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
                paymentMethodMap.put(id, new PaymentMethod(id, name));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paymentMethodMap;
    }
}
