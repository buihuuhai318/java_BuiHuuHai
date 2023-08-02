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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "list":
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Items> itemsList = new ArrayList<>(itemService.selectAllItem().values());
        List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
        request.setAttribute("itemsList", itemsList);
        request.setAttribute("itemTypeList", itemTypeList);
        request.getRequestDispatcher("admin/item-list.jsp").forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Items items = itemService.selectItem(id);
        List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
        List<ItemImage> imageList = itemImageService.selectImageByItem(id);
        request.setAttribute("items", items);
        request.setAttribute("itemTypeList", itemTypeList);
        request.setAttribute("imageList", imageList);
        request.getRequestDispatcher("admin/item-edit.jsp").forward(request, response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
        request.setAttribute("itemTypeList", itemTypeList);
        request.getRequestDispatcher("admin/item-create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int price = Integer.parseInt(request.getParameter("price"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        ItemType itemType = itemTypeService.selectItemType(typeId);
        int available = Integer.parseInt(request.getParameter("available"));
        String decreption = request.getParameter("decreption");

        Items items = itemService.selectItem(id);

        items.setName(name);
        items.setCode(code);
        items.setPrice(price);
        items.setInventory(inventory);
        items.setItemType(itemType);
        items.setAvailable(available);
        items.setDecreption(decreption);

        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String image4 = request.getParameter("image4");

        List<ItemImage> imageListTemp = new ArrayList<>();
        imageListTemp.add(new ItemImage(image1, items));
        imageListTemp.add(new ItemImage(image2, items));
        imageListTemp.add(new ItemImage(image3, items));
        imageListTemp.add(new ItemImage(image4, items));

        List<ItemImage> imageList = itemImageService.selectImageByItem(id);
        if (imageList.size() == 0) {
            for (ItemImage itemImage : imageListTemp) {
                if (itemImage.getUrl().equals("")) {
                    continue;
                }
                itemImageService.insertImage(itemImage);
            }
        } else {
            itemImageService.deleteImageByItem(id);
            for (ItemImage itemImage : imageListTemp) {
                if (itemImage.getUrl().equals("")) {
                    continue;
                }
                itemImageService.updateImage(id, itemImage);
            }
        }
        response.sendRedirect("ItemServlet?action=list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int price = Integer.parseInt(request.getParameter("price"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        ItemType itemType = itemTypeService.selectItemType(typeId);
        int available = Integer.parseInt(request.getParameter("available"));
        String decreption = request.getParameter("decreption");
        Items items = new Items(code, name, price, inventory, available, decreption, itemType);
        itemService.insertItem(items);
        Items itemsTemp = itemService.selectAllItemByCode().get(code);
        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String image4 = request.getParameter("image4");
        List<ItemImage> imageList = new ArrayList<>();
        imageList.add(new ItemImage(image1, itemsTemp));
        imageList.add(new ItemImage(image2, itemsTemp));
        imageList.add(new ItemImage(image3, itemsTemp));
        imageList.add(new ItemImage(image4, itemsTemp));
        for (ItemImage itemImage : imageList) {
            if (itemImage.getUrl().equals("")) {
                continue;
            }
            itemImageService.insertImage(itemImage);
        }
        response.sendRedirect("ItemServlet?action=list");
    }
}