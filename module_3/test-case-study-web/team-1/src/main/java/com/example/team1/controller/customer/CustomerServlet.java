package com.example.team1.controller.customer;

import com.example.team1.model.customers.Customers;
import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.customers.Types;
import com.example.team1.model.order.Cart;
import com.example.team1.model.order.OrderDetail;
import com.example.team1.model.payment.Bill;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.customer.CustomerService;
import com.example.team1.service.customer.ICustomerService;
import com.example.team1.service.customer.ITypeService;
import com.example.team1.service.customer.TypeService;
import com.example.team1.service.order.CartService;
import com.example.team1.service.order.ICartService;
import com.example.team1.service.order.IOrderDetailService;
import com.example.team1.service.order.OrderDetailService;
import com.example.team1.service.payment.BillService;
import com.example.team1.service.payment.IBillService;
import com.example.team1.service.statistical_board.IStatisticalBoardService;
import com.example.team1.service.statistical_board.StatisticalBoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final ICustomerService customerService = new CustomerService();
    private static final IAccountService accountService = new AccountService();
    private static final ITypeService typeService = new TypeService();
    private static final IStatisticalBoardService boardService = new StatisticalBoardService();
    private static final IOrderDetailService orderDetailService = new OrderDetailService();
    private static final IBillService billService = new BillService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request, response);
                break;
            case "list":
                showList(request, response);
                break;
            case "editList":
                showEditList(request, response);
            case "delete":
                delete(request, response);
                break;
            case "showBill":
                showBill(request, response);
                break;
            case "showCartDetail":
                showCartDetail(request, response);
                break;
            default:
                showInfo(request, response);
                break;
        }
    }

    private boolean checkRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("role") != null) {
                return (Integer) session.getAttribute("role") == 1;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void headCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            List<OrderDetail> orderList = new ArrayList<>(cart.getDetailList().values());
            request.setAttribute("orderList", orderList);
        }
    }

    private void showCartDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        headCart(request, response);
        int idCart = Integer.parseInt(request.getParameter("idCart"));
        List<OrderDetail> orderList = new ArrayList<>(orderDetailService.selectAllOrderByIdCart(idCart).values());
        request.setAttribute("order", orderList);
        request.getRequestDispatcher("shop/view-cart-detail.jsp").forward(request, response);
    }

    private void showBill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        headCart(request, response);
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());
        request.setAttribute("customers", customers);
        List<Bill> listBill = billService.selectAllByAccount(id);
        request.setAttribute("listBill", listBill);
        request.getRequestDispatcher("/shop/dashboard.jsp").forward(request, response);
    }

    private void showEditList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Customers customers = customerService.selectCustomer(id);
            List<Types> typesList = new ArrayList<>(typeService.selectAllType().values());
            request.setAttribute("customers", customers);
            request.setAttribute("typesList", typesList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit-profile-customer.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void showInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        headCart(request, response);
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");

        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());

        RequestDispatcher requestDispatcher;

        if (customers == null) {
            requestDispatcher = request.getRequestDispatcher("/shop/create-info-customer.jsp");
        } else {
            headCart(request, response);
            request.setAttribute("customers", customers);
            requestDispatcher = request.getRequestDispatcher("/shop/profile-details.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (checkRole(request, response)) {
            List<Customers> customersList = new ArrayList<>(customerService.selectAllCustomer().values());
            request.setAttribute("customersList", customersList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/customer-list.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/ShopServlet");
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());
        headCart(request, response);
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop/edit-info-customer.jsp");
        requestDispatcher.forward(request, response);
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
            case "editList":
                editList(request, response);
                break;
        }
    }

    private void editList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        headCart(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        Types types = typeService.selectType(Integer.parseInt(request.getParameter("customerTypes")));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int available = Integer.parseInt(request.getParameter("available"));
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");

        Customers customers = customerService.selectCustomer(id);
        Accounts accounts = accountService.selectAllAccountByEmail().get(customers.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accountService.setAvailableAccount(accounts.getId(), available == 0);
            customers.setId(id);
            customers.setType(types);
            customers.setName(name);
            customers.setAddress(address);
            customers.setBirthday(birthday);
            customers.setGender(gender);
            customers.setStatus(available);
            customers.setPhone(phone);
            if (!image.equals("")) {
                customers.setImage(image);
            }
            customerService.updateCustomer(customers.getId(), customers);
        }
        response.sendRedirect("/CustomerServlet?action=list");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        headCart(request, response);
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");

        customers.setName(name);
        customers.setAddress(address);
        customers.setBirthday(birthday);
        customers.setGender(gender);
        customers.setPhone(phone);
        customers.setImage(image);

        customerService.updateCustomer(customers.getId(), customers);
        request.setAttribute("customers", customers);
        request.setAttribute("done", "done");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/profile-details.jsp");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customerService.selectCustomer(id);
        Accounts accounts = accountService.selectAllAccountByEmail().get(customers.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accountService.setAvailableAccount(accounts.getId(), false);
            customerService.setAvailableCustomer(id, false);
        }
        response.sendRedirect("/CustomerServlet?action=list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        headCart(request, response);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String date = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");

        Accounts accounts = accountService.selectAccount(id);
        Customers customers = new Customers(name, gender, date, phone, address, image, typeService.selectType(Types.SLIVER), accounts);
        customerService.insertCustomer(customers);
        request.setAttribute("done", "done");
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop/profile-details.jsp");
        requestDispatcher.forward(request, response);
    }
}
