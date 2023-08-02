package com.example.team1.controller.shop;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.customers.Customers;
import com.example.team1.model.item.ItemImage;
import com.example.team1.model.item.ItemType;
import com.example.team1.model.item.Items;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.customer.CustomerService;
import com.example.team1.service.customer.ICustomerService;
import com.example.team1.service.item.*;
import com.example.team1.service.order.CartService;
import com.example.team1.service.order.ICartService;
import com.example.team1.service.order.IOrderDetailService;
import com.example.team1.service.order.OrderDetailService;
import com.example.team1.service.payment.IPaymentMethodService;
import com.example.team1.service.payment.PaymentMethodService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShopServlet", value = "/ShopServlet")
public class ShopServlet extends HttpServlet {

    private static final IItemService itemService = new ItemService();
    private static final IItemTypeService itemTypeService = new ItemTypeService();
    private static final IItemImageService itemImageService = new ItemImageService();
    private static final ICartService cartService = new CartService();
    private static final IOrderDetailService orderDetailService = new OrderDetailService();
    private static final IAccountService accountService = new AccountService();
    private static final ICustomerService customerService = new CustomerService();
    private static final IPaymentMethodService paymentMethodService = new PaymentMethodService();

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
                break;
            case "viewCart":
                viewCart(request, response);
                break;
            case "deleteCart":
                deleteCart(request, response);
                break;
            case "checkOut":
                checkOut(request, response);
                break;
            case "search":
                searchItem(request, response);
            default:
                showIndex(request, response);
                break;
        }
    }

    private void searchItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");
        List<Items> itemsList = new ArrayList<>(itemService.searchItem(searchKeyword).values());
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
            request.setAttribute("orderList", orderList);
        }
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("shop/shop.jsp").forward(request, response);
    }

    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());
        request.setAttribute("customers", customers);
        Cart cart = (Cart) session.getAttribute("cart");
        List<PaymentMethod> paymentMethodList = new ArrayList<>(paymentMethodService.selectAll().values());
        List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
        request.setAttribute("orderList", orderList);
        request.setAttribute("paymentMethodList", paymentMethodList);
        request.getRequestDispatcher("shop/checkout.jsp").forward(request, response);
    }

    private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        orderDetailService.deleteOrder(cart.getId(), id);
        Map<Integer, OrderDetail> orderMap = cart.getDetailList();
        orderMap.remove(id);
        List<OrderDetail> orderList = new ArrayList<>(orderMap.values());
        session.setAttribute("cart", cart);
        request.setAttribute("orderList", orderList);
        String referer = request.getHeader("referer");
        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            // Nếu không có trang trước đó, điều hướng về trang chủ hoặc trang giỏ hàng mặc định
            request.getRequestDispatcher("shop/cart.jsp").forward(request, response); // hoặc trang giỏ hàng mặc định
        }
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("shop/cart.jsp").forward(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Items items = itemService.selectItem(id);
        List<ItemImage> imageList = itemImageService.selectImageByItem(id);
        request.setAttribute("items", items);
        request.setAttribute("imageList", imageList);
        List<Items> itemsList = new ArrayList<>(itemService.selectItemByType(items.getItemType().getId()).values());
        request.setAttribute("itemsList", itemsList);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
            request.setAttribute("orderList", orderList);
        }
        request.getRequestDispatcher("shop/product-single.jsp").forward(request, response);
    }

    private void viewByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idType"));
        ItemType types = itemTypeService.selectItemType(id);
        List<Items> itemsList = new ArrayList<>(itemService.selectItemByType(id).values());
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
            request.setAttribute("orderList", orderList);
        }
        request.setAttribute("itemsList", itemsList);
        request.setAttribute("types", types);
        request.getRequestDispatcher("shop/shop.jsp").forward(request, response);
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Items> itemsList = new ArrayList<>(itemService.selectItemHot().values());
        List<ItemType> itemTypeList = new ArrayList<>(itemTypeService.selectAllItemType().values());
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
            request.setAttribute("orderList", orderList);
        }
        request.setAttribute("itemsList", itemsList);
        request.setAttribute("itemTypeList", itemTypeList);
        request.getRequestDispatcher("shop/index.jsp").forward(request, response);
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