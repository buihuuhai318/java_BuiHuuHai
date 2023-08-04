package com.example.team1.controller.admin;

import com.example.team1.model.dto.HotCustomer;
import com.example.team1.model.dto.HotItems;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.model.payment.Bill;
import com.example.team1.model.payment.PaymentMethod;
import com.example.team1.service.order.IOrderDetailService;
import com.example.team1.service.order.OrderDetailService;
import com.example.team1.service.payment.BillService;
import com.example.team1.service.payment.IBillService;
import com.example.team1.service.payment.IPaymentMethodService;
import com.example.team1.service.payment.PaymentMethodService;
import com.example.team1.service.statistical_board.IStatisticalBoardService;
import com.example.team1.service.statistical_board.StatisticalBoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private static final IStatisticalBoardService boardService = new StatisticalBoardService();
    private static final IOrderDetailService orderDetailService = new OrderDetailService();
    private static final IBillService billService = new BillService();
    private static final IPaymentMethodService paymentMethodService = new PaymentMethodService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showBill":
                showBill(request, response);
                break;
            case "showCart":
                showCart(request, response);
                break;
            case "showPayment":
                showPayment(request, response);
                break;
            case "deleteMethod":
                deleteMethod(request, response);
                break;
            default:
                showIndex(request, response);
                break;
        }
    }

    private void deleteMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idMethod = Integer.parseInt(request.getParameter("idMethod"));
        PaymentMethod paymentMethod = paymentMethodService.getPayment(idMethod);
        paymentMethodService.setAvailableMethod(idMethod, paymentMethod.getAvailable() != 0);
        response.sendRedirect("AdminServlet?action=showPayment");
    }

    private void showPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PaymentMethod> methodList = new ArrayList<>(paymentMethodService.selectAll().values());
        request.setAttribute("methodList", methodList);
        request.getRequestDispatcher("/admin/payment-method-list.jsp").forward(request, response);
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        List<OrderDetail> orderList = new ArrayList<>(orderDetailService.selectAllOrderByIdCart(idCart).values());
        request.setAttribute("order", orderList);
        request.getRequestDispatcher("/admin/view-cart-detail.jsp").forward(request, response);
    }

    private void showBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bill> listBill = new ArrayList<>(billService.selectAll());
        request.setAttribute("listBill", listBill);
        request.getRequestDispatcher("/admin/bill-list.jsp").forward(request, response);
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HotCustomer> customerList = boardService.selectAllCustomer();
        List<HotItems> itemsList = boardService.selectAllItem();
        int day = boardService.totalByDay();
        int month = boardService.totalByMonth();
        int year = boardService.totalByYear();
        request.setAttribute("day", day);
        request.setAttribute("month", month);
        request.setAttribute("year", year);
        request.setAttribute("customerList", customerList);
        request.setAttribute("itemsList", itemsList);
        request.getRequestDispatcher("admin/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}