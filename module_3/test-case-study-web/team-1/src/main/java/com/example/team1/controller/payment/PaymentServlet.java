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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@WebServlet(name = "PaymentServlet", value = "/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    private static final ICartService cartService = new CartService();

    private static final IPaymentMethodService paymentMethodService = new PaymentMethodService();

    private static final IBillService billService = new BillService();

    private static final IAccountService accountService = new AccountService();

    private static final IItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "getVnPay":
                getVnPay(request, response);
                break;
            case "getBill":
                getBill(request, response);
                break;
            default:
                String mess = request.getParameter("vnp_ResponseCode");
                if (mess.equals("00")) {
                    request.setAttribute("done", "done");

                } else {
                    request.setAttribute("fail", "fail");
                }
                request.getRequestDispatcher("/ShopServlet?action=checkOut").forward(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "getVnPay":
                getVnPay(request, response);
                break;
            case "getBill":
                getBill(request, response);
                break;
            default:
                checkPaymentMethod(request, response);
                break;
        }
    }

    private void checkPaymentMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idPaymentMethod = Integer.parseInt(request.getParameter("paymentMethod"));
        if (idPaymentMethod == 2) {
            getVnPay(request, response);
        } else {
            getBill(request, response);
        }
    }

    protected void getVnPay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_OrderInfo = "Thanh toán đơn hàng: " + vnp_TxnRef;
        String orderType = "150000";
        String vnp_IpAddr = "0:0:0:0:0:0:0:1";
        String vnp_TmnCode = Config.vnp_TmnCode;
        int price = Integer.parseInt(request.getParameter("totalPrice"));
        int amount = price * 23000 * 100;
        Map vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
        String bank_code = request.getParameter("bankcode");
        if (bank_code != null && !bank_code.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bank_code);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.1.0 Version
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        //Billing

        //Build data to hash and querystring
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
        // Chuyển hướng đến URL thanh toán
        response.sendRedirect(paymentUrl);
    }

    protected void getBill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            int paymentStatus = 0;
            if (request.getParameter("billDone") != null) {
                paymentStatus = 1;
            }
            Bill bill = new Bill(cart.getId(), paymentMethod, quantity, price, phone, address, paymentStatus);
            billService.insertBill(bill);
            List<OrderDetail> orderDetailList = new ArrayList<>(cart.getDetailList().values());
            Items items;
            for (OrderDetail orderDetail : orderDetailList) {
                items = orderDetail.getItems();
                items.setInventory(items.getInventory() - orderDetail.getQuantity());
                if (items.getInventory() - orderDetail.getQuantity() > 0) {
                    itemService.availableItem(items.getId(), true);

                }
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