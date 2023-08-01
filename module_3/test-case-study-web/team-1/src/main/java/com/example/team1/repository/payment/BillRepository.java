package com.example.team1.repository.payment;

import com.example.team1.model.payment.Bill;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillRepository implements IBillRepository {

    private static final String INSERT = "insert into bill (cart_id, payment_id, bill_date, total_price, phone, address) values (?, ?, ?, ?, ?, ?);";

    @Override
    public void insertBill(Bill bill) {
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, bill.getCart().getId());
            preparedStatement.setInt(2, bill.getPaymentMethod().getId());
            preparedStatement.setString(3, bill.getDate());
            preparedStatement.setInt(4, bill.getTotalPrice());
            preparedStatement.setString(5, bill.getPhone());
            preparedStatement.setString(6, bill.getAddress());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
