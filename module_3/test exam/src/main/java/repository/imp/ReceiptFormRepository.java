package repository.imp;

import model.ReceiptForm;
import repository.Base;
import repository.IReceiptFormRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReceiptFormRepository implements IReceiptFormRepository {
    private static final String SELECT = "select * from receipt where receipt_id = ?;";
    private static final String SELECT_ALL = "select * from receipt;";

    @Override
    public Map<Integer, ReceiptForm> listReceipt() {
        Map<Integer, ReceiptForm> receiptFormMap = new HashMap<>();

        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("receipt_id");
                String name = resultSet.getString("receipt_name");
                ReceiptForm receiptForm = new ReceiptForm(id ,name);
                receiptFormMap.put(id, receiptForm);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return receiptFormMap;
    }

    @Override
    public ReceiptForm select(int id) {
        ReceiptForm receiptForm = new ReceiptForm();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int receiptId = resultSet.getInt("receipt_id");
                String name = resultSet.getString("receipt_name");
                receiptForm = new ReceiptForm(receiptId ,name);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return receiptForm;
    }
}
