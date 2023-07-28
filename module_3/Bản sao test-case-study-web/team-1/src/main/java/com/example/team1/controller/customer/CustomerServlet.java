package com.example.team1.controller.customer;

import com.example.team1.model.customers.Customers;
import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.customers.Types;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.customer.CustomerService;
import com.example.team1.service.customer.ICustomerService;
import com.example.team1.service.customer.ITypeService;
import com.example.team1.service.customer.TypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    IAccountService accountService = new AccountService();
    ITypeService typeService = new TypeService();


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
            default:
                showInfo(request, response);
                break;
        }
    }

    private void showEditList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customers customers = customerService.selectCustomer(id);
        List<Types> typesList = new ArrayList<>(typeService.selectAllType().values());
        request.setAttribute("customers", customers);
        request.setAttribute("typesList", typesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit-profile-customer.jsp");
        dispatcher.forward(request, response);
    }

    private void showInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");

        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());

        RequestDispatcher requestDispatcher;

        if (customers == null) {
            requestDispatcher = request.getRequestDispatcher("/shop/create-info-customer.jsp");
        } else {
            request.setAttribute("customers", customers);
            requestDispatcher = request.getRequestDispatcher("/shop/profile-details.jsp");
        }
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = new ArrayList<>(customerService.selectAllCustomer().values());
        request.setAttribute("customersList", customersList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());

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
            accountService.deleteAccount(accounts.getId(), available == 1);
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
        response.sendRedirect("CustomerServlet?action=list");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");

        customers.setName(name);
        customers.setAddress(address);
        customers.setBirthday(birthday);
        customers.setGender(gender);
        customers.setPhone(phone);

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
            accountService.deleteAccount(accounts.getId(), true);
            customerService.deleteCustomer(id, true);
        }
        response.sendRedirect("CustomerServlet?action=list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
