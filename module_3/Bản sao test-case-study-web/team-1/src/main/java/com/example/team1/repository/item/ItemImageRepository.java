package com.example.team1.repository.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.repository.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemImageRepository implements IItemImageRepository {
    private static final String INSERT = "insert into item_images (image_url, item_id) values (?, ?);";
    private static final String SELECT_BY_ITEM_ID = "select * from item_images where item_id = ?;";
    private static final String DELETE = "delete from item_images where image_id = ?;";
    private static final String UPDATE = "update item_images set image_url = ? where image_id = ?;";
    private static final String DELETE_BY_ITEM_ID = "delete from item_images where item_id = ?;";

    @Override
    public void insertImage(ItemImage itemImage) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, itemImage.getUrl());
            preparedStatement.setInt(2, itemImage.getItems().getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateImage(int id, ItemImage itemImage) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, itemImage.getUrl());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ItemImage> selectImageByItem(int id) {
        List<ItemImage> imageList = new ArrayList<>();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ITEM_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idImage = resultSet.getInt("image_id");
                String url = resultSet.getString("image_url");
                imageList.add(new ItemImage(idImage, url));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    @Override
    public void deleteImage(int id) {
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
    public void deleteImageByItem(int id) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ITEM_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
