package com.example.team1.controller.cart;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.item.Items;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.item.*;
import com.example.team1.service.order.CartService;
import com.example.team1.service.order.ICartService;
import com.example.team1.service.order.IOrderDetailService;
import com.example.team1.service.order.OrderDetailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {

    private static final IItemService itemService = new ItemService();
    private static final IItemTypeService itemTypeService = new ItemTypeService();
    private static final IItemImageService itemImageService = new ItemImageService();
    private static final ICartService cartService = new CartService();
    private static final IOrderDetailService orderDetailService = new OrderDetailService();
    private static final IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("id_account") != null) {
            int accounts = (int) session.getAttribute("id_account");
            int quantity = 1;
            int id;
            if (request.getParameter("itemId") != null) {
                id = Integer.parseInt(request.getParameter("itemId"));
                Items items = itemService.selectItem(id);
                if (items != null) {
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    if (session.getAttribute("cart") == null) {
                        Cart cart = new Cart(accounts);
                        cartService.insertCart(cart);
                        cart = cartService.selectLastCart();
                        Map<Integer, OrderDetail> orderDetailMap = new HashMap<>();
                        OrderDetail orderDetail = new OrderDetail(cart.getId(), items, quantity, items.getPrice());
                        orderDetailMap.put(id, orderDetail);
                        orderDetailService.insertOrder(orderDetail);
                        cart.setDetailList(orderDetailMap);
                        List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
                        session.setAttribute("cart", cart);
                        session.setAttribute("cartId", cart.getId());
                        request.setAttribute("orderList", orderList);
                        String referer = request.getHeader("referer");
                        if (referer != null) {
                            response.sendRedirect(referer);
                        } else {
                            // Nếu không có trang trước đó, điều hướng về trang chủ hoặc trang giỏ hàng mặc định
                            request.getRequestDispatcher("shop/cart.jsp").forward(request, response); // hoặc trang giỏ hàng mặc định
                        }
                    } else {
                        Cart cart = (Cart) session.getAttribute("cart");
                        Map<Integer, OrderDetail> orderDetailMap = cart.getDetailList();
                        boolean check = false;
                        for (OrderDetail orderDetail : orderDetailMap.values()) {
                            if (orderDetail.getItems().getId() == items.getId()) {
                                orderDetail.setQuantity(orderDetail.getQuantity() + quantity);
                                orderDetail.setPrice(items.getPrice());
                                orderDetailService.updateOrder(cart.getId(), orderDetail);
                                check = true;
                            }
                        }
                        if (!check) {
                            OrderDetail orderDetail = new OrderDetail(cart.getId(), items, quantity, items.getPrice());
                            orderDetailMap.put(id, orderDetail);
                            orderDetailService.insertOrder(orderDetail);
                        }
                        session.setAttribute("cart", cart);
                        session.setAttribute("cartId", cart.getId());
                        List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
                        request.setAttribute("orderList", orderList);
                        String referer = request.getHeader("referer");
                        if (referer != null) {
                            response.sendRedirect(referer);
                        } else {
                            // Nếu không có trang trước đó, điều hướng về trang chủ hoặc trang giỏ hàng mặc định
                            request.getRequestDispatcher("shop/cart.jsp").forward(request, response); // hoặc trang giỏ hàng mặc định
                        }
                    }
                }
            }
        } else {
            response.sendRedirect("/shop/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}