package com.example.team1.controller.payment;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.item.Items;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.model.payment.Bill;
import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.item.IItemService;
import com.example.team1.service.item.ItemService;
import com.example.team1.service.order.CartService;
import com.example.team1.service.order.ICartService;
import com.example.team1.service.payment.BillService;
import com.example.team1.service.payment.IBillService;
import com.example.team1.service.payment.IPaymentMethodService;
import com.example.team1.service.payment.PaymentMethodService;
import com.example.team1.util.Email;

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

    private static final IAccountService accountService = new AccountService();

    private static final IItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Accounts accounts = accountService.selectAccount((Integer) session.getAttribute("id_account"));
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            cart.setPaymentDate(String.valueOf(LocalDate.now()));
            cart.setPaymentStatus(1);
            cartService.updateCart(cart);
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            int price = Integer.parseInt(request.getParameter("totalPrice"));
            int quantity = Integer.parseInt(request.getParameter("totalQuantity"));
            int paymentId = Integer.parseInt(request.getParameter("paymentMethod"));
            PaymentMethod paymentMethod = paymentMethodService.selectAll().get(paymentId);
            Bill bill = new Bill(cart.getId(), paymentMethod, quantity, price, phone, address);
            billService.insertBill(bill);
            List<OrderDetail> orderDetailList = new ArrayList<>(cart.getDetailList().values());
            Items items;
            for (OrderDetail orderDetail : orderDetailList) {
                items = orderDetail.getItems();
                items.setInventory(items.getInventory() - orderDetail.getQuantity());
                itemService.updateInventoryItem(items.getId(), items);
            }
            request.setAttribute("bill", bill);
            request.setAttribute("cart", cart);
            session.removeAttribute("cart");
            session.removeAttribute("cartId");
            String content = Email.getContent(bill, cart);
            Email.sendEmail(accounts.getEmail(), "#Thehome - Purchase Confirmation - Payment: " + cart.getId(), content);
            request.getRequestDispatcher("shop/purchase-confirmation.jsp").forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }
}