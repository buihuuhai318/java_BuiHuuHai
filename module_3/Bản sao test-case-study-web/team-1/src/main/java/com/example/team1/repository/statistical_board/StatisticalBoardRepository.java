package com.example.team1.repository.statistical_board;


import com.example.team1.model.dto.HotCustomer;
import com.example.team1.model.dto.HotItems;
import com.example.team1.repository.Base;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StatisticalBoardRepository implements IStatisticalBoardRepository {
    private static final String SELECT_ITEM = "call hot_items;";
    private static final String SELECT_CUSTOMER = "call hot_accounts;";
    private static final String DAY = "call revenue_by_current_day;";
    private static final String MONTH = "call revenue_by_current_month;";
    private static final String YEAR = "call revenue_by_current_year;";
    private static final String REVENUE_EACH_MONTH = "call revenue_year;";
    private static final String TOTAL_EACH_TYPE = "call total_each_type;";

    @Override
    public List<HotCustomer> selectAllCustomer() {
        List<HotCustomer> list = new ArrayList<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String username = resultSet.getString("account_username");
                String name = resultSet.getString("customer_name");
                String typeName = resultSet.getString("customer_type_name");
                int totalBill = resultSet.getInt("total_bill");
                int totalPrice = resultSet.getInt("total_price");
                list.add(new HotCustomer(id, username, name, typeName, totalBill, totalPrice));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HotItems> selectAllItem() {
        List<HotItems> list = new ArrayList<>();
        Connection connection = Base.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                String itemName = resultSet.getString("item_name");
                String typeName = resultSet.getString("item_type_name");
                int totalQuantity = resultSet.getInt("total_quantity");
                int totalPrice = resultSet.getInt("total_price");
                list.add(new HotItems(id, itemName, typeName, totalQuantity, totalPrice));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public int totalByDay() {
        int total = 0;
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DAY);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getInt("total_revenue");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    @Override
    public int totalByMonth() {
        int total = 0;
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(MONTH);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getInt("total_revenue");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    @Override
    public int totalByYear() {
        int total = 0;
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(YEAR);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                total = resultSet.getInt("total_revenue");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return total;
    }

    @Override
    public List<Integer> revenueList() {
        List<Integer> revenueList = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(REVENUE_EACH_MONTH);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                revenueList.add(resultSet.getInt("revenue"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return revenueList;
    }

    @Override
    public Map<String, Integer> quantityTotalByType() {
        Map<String, Integer> quantityTotal = new HashMap<>();
        Connection connection = Base.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(TOTAL_EACH_TYPE);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                quantityTotal.put(resultSet.getString("type_name"), resultSet.getInt("total_quantity_sold"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quantityTotal;
    }
}
