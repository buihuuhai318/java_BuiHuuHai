package com.example.team1.controller.employee;

import com.example.team1.model.customers.Customers;
import com.example.team1.model.employee.Employees;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.employee.EmployeeService;
import com.example.team1.service.employee.IEmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    IAccountService accountService = new AccountService();
    IEmployeeService employeeService = new EmployeeService();

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

    private void showInfo(HttpServletRequest request, HttpServletResponse response) {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEditList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employees> employeesList = new ArrayList<>(employeeService.selectAllEmployee().values());
        request.setAttribute("employeesList", employeesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {

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

    private void editList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {

    }
}