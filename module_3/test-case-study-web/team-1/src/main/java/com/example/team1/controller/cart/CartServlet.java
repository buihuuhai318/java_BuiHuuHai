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
import java.util.List;

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
            Accounts accounts = accountService.selectAccount((Integer) session.getAttribute("id_account"));
            int quantity = 1;
            int id;
            if (request.getParameter("itemId") != null) {
                id = Integer.parseInt(request.getParameter("itemId"));
                Items items = itemService.selectItem(id);
                if (items != null) {
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    if (session.getAttribute("cartId") == null) {
                        Cart cart = new Cart(accounts);
                        cartService.insertCart(cart);
                        cart = cartService.selectLastCart();
                        List<OrderDetail> orderList = new ArrayList<>();
                        OrderDetail orderDetail = new OrderDetail(cart.getId(), items, quantity, items.getPrice());
                        orderList.add(orderDetail);
                        orderDetailService.insertOrder(orderDetail);
                        cart.setDetailList(orderList);
                        session.setAttribute("cart", cart);
                        session.setAttribute("cartId", cart.getId());
                        request.setAttribute("orderList", orderList);
                        request.getRequestDispatcher("shop/cart.jsp").forward(request, response);
                    } else {
                        Cart cart = (Cart) session.getAttribute("cart");
                        List<OrderDetail> orderList = cart.getDetailList();
                        boolean check = false;
                        for (OrderDetail orderDetail : orderList) {
                            if (orderDetail.getItems().getId() == items.getId()) {
                                orderDetail.setQuantity(orderDetail.getQuantity() + quantity);
                                orderDetail.setPrice(orderDetail.getPrice() + items.getPrice());
                                orderDetailService.updateOrder(cart.getId(), orderDetail);
                                check = true;
                            }
                        }
                        if (!check) {
                            OrderDetail orderDetail = new OrderDetail(cart.getId(), items, quantity, items.getPrice());
                            orderList.add(orderDetail);
                            orderDetailService.insertOrder(orderDetail);
                        }
                        session.setAttribute("cart", cart);
                        session.setAttribute("cartId", cart.getId());
                        request.setAttribute("orderList", orderList);
                        request.getRequestDispatcher("shop/cart.jsp").forward(request, response);
                    }
                }
            }
        } else {
            response.sendRedirect("/shop/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}