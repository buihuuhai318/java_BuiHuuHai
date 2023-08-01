package com.example.team1.controller.payment;

import com.example.team1.controller.shop.ShopServlet;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.model.payment.Bill;
import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.service.order.CartService;
import com.example.team1.service.order.ICartService;
import com.example.team1.service.payment.BillService;
import com.example.team1.service.payment.IBillService;
import com.example.team1.service.payment.IPaymentMethodService;
import com.example.team1.service.payment.PaymentMethodService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    private static final ICartService cartService = new CartService();

    private static final IPaymentMethodService paymentMethodService = new PaymentMethodService();

    private static final IBillService billService = new BillService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            cart.setPaymentDate(String.valueOf(LocalDate.now()));
            cart.setPaymentStatus(1);
            cartService.updateCart(cart);
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int price = Integer.parseInt(request.getParameter("totalPrice"));
            int paymentId = Integer.parseInt(request.getParameter("paymentMethod"));
            PaymentMethod paymentMethod = paymentMethodService.selectAll().get(paymentId);
            Bill bill = new Bill(cart, paymentMethod, price, phone, address);
            billService.insertBill(bill);
            request.setAttribute("bill", bill);
            request.setAttribute("cart", cart);
            session.invalidate();
            request.getRequestDispatcher("shop/purchase-confirmation.jsp").forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }
}