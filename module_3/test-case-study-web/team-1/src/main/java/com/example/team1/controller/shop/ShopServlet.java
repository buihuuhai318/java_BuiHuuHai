package com.example.team1.controller.shop;

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

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {

    private final IItemService itemService = new ItemService();
    private final IItemTypeService itemTypeService = new ItemTypeService();
    private final ItemImageService itemImageService = new ItemImageService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "viewByType":
                viewByType(request, response);
                break;
            case "viewDetail":
                viewDetail(request, response);
            default:
                showIndex(request, response);
                break;
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Items items = itemService.selectItem(id);
        List<ItemImage> imageList = itemImageService.selectImageByItem(id);
        request.setAttribute("items", items);
        request.setAttribute("imageList", imageList);
        request.getRequestDispatcher("shop/product-single.jsp").forward(request, response);
    }

    private void viewByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idType"));
        List<Items> itemsList = new ArrayList<>(itemService.selectItemByType(id).values());
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("shop/shop.jsp").forward(request, response);
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Items> itemsList = new ArrayList<>(itemService.selectItemHot().values());
        List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
        request.setAttribute("itemsList", itemsList);
        request.setAttribute("itemTypeList", itemTypeList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        switch (action) {
//            case "create":
//                create(request, response);
//                break;
//            case "edit":
//                edit(request, response);
//                break;
//        }
    }
}