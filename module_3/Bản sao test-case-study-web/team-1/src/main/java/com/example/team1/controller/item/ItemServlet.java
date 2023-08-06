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

    private boolean checkRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("role") != null) {
                return (Integer) session.getAttribute("role") != 3;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
            List<Items> itemsList = new ArrayList<>(itemService.selectAllItem().values());
            List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
            request.setAttribute("itemsList", itemsList);
            request.setAttribute("itemTypeList", itemTypeList);
            request.getRequestDispatcher("admin/item-list.jsp").forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Items items = itemService.selectItem(id);
            List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
            List<ItemImage> imageList = itemImageService.selectImageByItem(id);
            request.setAttribute("items", items);
            request.setAttribute("itemTypeList", itemTypeList);
            request.setAttribute("imageList", imageList);
            request.getRequestDispatcher("admin/item-edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (checkRole(request, response)) {
            int id = Integer.parseInt(request.getParameter("id"));
            itemService.availableItem(id, false);
            response.sendRedirect("/ItemServlet?action=list");
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
            List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
            request.setAttribute("itemTypeList", itemTypeList);
            request.getRequestDispatcher("admin/item-create.jsp").forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
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
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkRole(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int price = Integer.parseInt(request.getParameter("price"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        ItemType itemType = itemTypeService.selectItemType(typeId);
        int available = Integer.parseInt(request.getParameter("available"));
        String description = request.getParameter("description");

        Items items = itemService.selectItem(id);

        items.setName(name);
        items.setCode(code);
        items.setPrice(price);
        items.setInventory(inventory);
        items.setItemType(itemType);
        items.setAvailable(available);
        items.setDescription(description);

        String image1 = request.getParameter("image1");
        String image2 = request.getParameter("image2");
        String image3 = request.getParameter("image3");
        String image4 = request.getParameter("image4");

        itemService.updateItem(id, items);

        List<ItemImage> imageListTemp = new ArrayList<>();
        imageListTemp.add(new ItemImage(image1, items));
        imageListTemp.add(new ItemImage(image2, items));
        imageListTemp.add(new ItemImage(image3, items));
        imageListTemp.add(new ItemImage(image4, items));

        boolean flag = false;
        for (ItemImage itemImage : imageListTemp) {
            if (itemImage.getUrl().equals("")) {
                continue;
            }
            flag = true;
            break;
        }

        List<ItemImage> imageList = itemImageService.selectImageByItem(id);
        if (imageList.size() < 4) {
            while (imageList.size() < 4) {
                ItemImage itemImage = new ItemImage("", items);
                imageList.add(itemImage);
                itemImageService.insertImage(itemImage);
            }
            for (int i = 0; i < imageListTemp.size(); i++) {
                if (imageListTemp.get(i).getUrl().equals("")) {
                    continue;
                }
                imageList.get(i).setUrl(imageListTemp.get(i).getUrl());
                itemImageService.updateImage(imageList.get(i).getId(), imageList.get(i));
            }
        } else {
            if (flag) {
                for (int i = 0; i < imageListTemp.size(); i++) {
                    if (imageListTemp.get(i).getUrl().equals("")) {
                        continue;
                    }
                    imageList.get(i).setUrl(imageListTemp.get(i).getUrl());
                    itemImageService.updateImage(imageList.get(i).getId(), imageList.get(i));
                }
            }
        }
        response.sendRedirect("ItemServlet?action=list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkRole(request, response);
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        int price = Integer.parseInt(request.getParameter("price"));
        int inventory = Integer.parseInt(request.getParameter("inventory"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        ItemType itemType = itemTypeService.selectItemType(typeId);
        int available = Integer.parseInt(request.getParameter("available"));
        String description = request.getParameter("description");
        Items items = new Items(code, name, price, inventory, available, description, itemType);
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