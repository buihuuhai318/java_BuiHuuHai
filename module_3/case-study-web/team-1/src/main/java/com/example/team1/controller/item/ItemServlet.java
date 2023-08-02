package com.example.team1.controller.item;

import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.service.item.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ItemServlet", value = "/ItemServlet")
public class ItemServlet extends HttpServlet {
    private final IItemService itemService = new ItemService();
    private final IItemTypeService itemTypeService = new ItemTypeService();
    private final ItemImageService itemImageService = new ItemImageService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}