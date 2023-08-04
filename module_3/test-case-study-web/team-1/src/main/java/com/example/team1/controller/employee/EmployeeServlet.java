package com.example.team1.controller.employee;

import com.example.team1.model.accounts.Accounts;
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

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employees employees = employeeService.selectEmployee(id);
        Accounts accounts = accountService.selectAllAccountByEmail().get(employees.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accountService.setAvailableAccount(accounts.getId(), false);
            employeeService.setAvailableEmployee(id, false);
        }
        response.sendRedirect("EmployeeServlet?action=list");
    }

    private void showEditList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employees employees = employeeService.selectEmployee(id);
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit-profile-employee.jsp");
        dispatcher.forward(request, response);
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

    private void editList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        int available = Integer.parseInt(request.getParameter("available"));
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");

        Employees employees = employeeService.selectEmployee(id);
        Accounts accounts = accountService.selectAllAccountByEmail().get(employees.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accountService.setAvailableAccount(accounts.getId(), available == 0);
            employees.setId(id);
            employees.setSalary(salary);
            employees.setName(name);
            employees.setAddress(address);
            employees.setBirthday(birthday);
            employees.setGender(gender);
            employees.setStatus(available);
            employees.setPhone(phone);
            if (!image.equals("")) {
                employees.setImage(image);
            }
            employeeService.updateEmployee(employees.getId(), employees);
        }
        response.sendRedirect("EmployeeServlet?action=list");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {

    }
}