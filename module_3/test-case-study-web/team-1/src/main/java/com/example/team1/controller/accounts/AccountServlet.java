package com.example.team1.controller.accounts;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.model.accounts.Roles;
import com.example.team1.model.customers.Customers;
import com.example.team1.model.customers.Types;
import com.example.team1.model.employee.Employees;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;
import com.example.team1.service.accounts.IRoleService;
import com.example.team1.service.accounts.RoleService;
import com.example.team1.service.customer.CustomerService;
import com.example.team1.service.customer.ICustomerService;
import com.example.team1.service.customer.ITypeService;
import com.example.team1.service.customer.TypeService;
import com.example.team1.service.employee.EmployeeService;
import com.example.team1.service.employee.IEmployeeService;
import com.example.team1.util.Email;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private final IAccountService accountService = new AccountService();
    private final ICustomerService customerService = new CustomerService();
    private final IEmployeeService employeeService = new EmployeeService();
    private final IRoleService roleService = new RoleService();
    private final ITypeService typeService = new TypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "createNew":
                showCreateNew(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "change":
                showChangePassword(request, response);
                break;
            case "logout":
                showLogout(request, response);
                break;
            case "login":
                showLogin(request, response);
                break;
            case "view":
                showIndex(request, response);
                break;
            case "list":
                showList(request, response);
                break;
            case "res":
                showResetPassword(request, response);
                break;
        }
    }

    private void showCreateNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Roles> rolesList = new ArrayList<>(roleService.selectAllRole().values());
        request.setAttribute("rolesList", rolesList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/create-new-account.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop/change-pass.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ShopServlet");
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Accounts> accountsList = new ArrayList<>(accountService.selectAllAccount().values());
        System.out.println(accountsList);

        request.setAttribute("accountsList", accountsList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/account-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Accounts accounts = accountService.selectAccount(id);
        List<Roles> rolesList = new ArrayList<>(roleService.selectAllRole().values());
        request.setAttribute("accounts", accounts);
        request.setAttribute("rolesList", rolesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/edit-profile-account.jsp");
        dispatcher.forward(request, response);
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username;
        String password;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            username = "";
            password = "";

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                } else if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }

            // Nếu có cả hai thông tin đăng nhập, thực hiện đăng nhập tự động
            if (username != null && password != null) {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.getRequestDispatcher("/shop/login.jsp").forward(request, response);
            }
        }
        response.sendRedirect("/shop/login.jsp");
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShopServlet");
        dispatcher.forward(request, response);
    }

    private void showResetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop/forget-password.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop/signin.jsp");
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
            case "res":
                accountResetPass(request, response);
                break;
            case "login":
                accountLogin(request, response);
                break;
            case "change":
                changePassword(request, response);
                break;
            case "createNew":
                createNew(request, response);
                break;
            case "newProfile":
                createNewProfile(request, response);
                break;
        }
    }

    private void createNewProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        Accounts accounts = accountService.selectAllAccountByEmail().get(email);

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String date = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        String image = request.getParameter("image");
        int available = Integer.parseInt(request.getParameter("available"));

        if (accounts.getRole().getId() == Roles.CUSTOMER) {
            Types types = typeService.selectType(Integer.parseInt(request.getParameter("customerTypes")));
            Customers customers = new Customers(name, gender, date, phone, address, available, image, types, accounts);
            customerService.insertCustomer(customers);
            response.sendRedirect("CustomerServlet?action=list");
        } else {
            int salary = Integer.parseInt(request.getParameter("salary"));
            Employees employees = new Employees(name, salary, gender, date, phone, address, available, image, accounts);
            employeeService.insertEmployee(employees);
            response.sendRedirect("EmployeeServlet?action=list");
        }
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Roles roles = roleService.selectRole(Integer.parseInt(request.getParameter("roleId")));
        RequestDispatcher dispatcher;
        if (accountService.checkAccount(email, username)) {
            Accounts accounts = new Accounts(email, username, password, roles);
            accountService.insertAccount(accounts);
            request.setAttribute("accounts", accounts);
            if (roles.getId() == Roles.CUSTOMER) {
                request.setAttribute("cus", "cus");
            } else {
                request.setAttribute("emp", "emp");
            }
            List<Types> typesList = new ArrayList<>(typeService.selectAllType().values());
            request.setAttribute("typesList", typesList);
            dispatcher = request.getRequestDispatcher("/admin/new-profile.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("fail", "fail");
            List<Roles> rolesList = new ArrayList<>(roleService.selectAllRole().values());
            request.setAttribute("rolesList", rolesList);
            dispatcher = getServletContext().getRequestDispatcher("/admin/create-new-account.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id_account");
        Accounts accounts = accountService.selectAccount(id);
        String oldPass = request.getParameter("old-pass");
        String newPass = request.getParameter("new-pass");
        String confirmPass = request.getParameter("confirm-pass");

        RequestDispatcher dispatcher;
        if (accounts.getPassword().equals(oldPass)) {
            if (newPass.equals(confirmPass)) {
                accounts.setPassword(newPass);
                accountService.updateAccount(id, accounts);
                request.setAttribute("done", "done");
            } else {
                request.setAttribute("pass", "pass");
            }
        } else {
            request.setAttribute("fail", "fail");
        }
        dispatcher = request.getRequestDispatcher("/shop/change-pass.jsp");
        dispatcher.forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String pass = request.getParameter("pass");
        int available = Integer.parseInt(request.getParameter("available"));
        Roles roles = roleService.selectRole(Integer.parseInt(request.getParameter("roleId")));

        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());
        Employees employees = employeeService.selectAllEmployeeByEmail().get(accounts.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accounts.setRole(roles);
            accounts.setPassword(pass);
            accounts.setAvailable(available);
            if (accounts.getRole().getId() == Accounts.CUSTOMER && customers != null) {
                customerService.setAvailableCustomer(customers.getId(), available == 0);
            } else if (accounts.getRole().getId() == Accounts.EMPLOYEE && employees != null) {
                employeeService.setAvailableEmployee(employees.getId(), available == 0);
            }
            accountService.updateAccount(id, accounts);
        }
        response.sendRedirect("AccountServlet?action=list");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Accounts accounts = accountService.selectAccount(id);
        Customers customers = customerService.selectAllCustomerByEmail().get(accounts.getEmail());
        Employees employees = employeeService.selectAllEmployeeByEmail().get(accounts.getEmail());

        if (accounts.getRole().getId() != Accounts.ADNIN) {
            accountService.setAvailableAccount(id, false);
            if (accounts.getRole().getId() == Accounts.CUSTOMER && customers != null) {
                customerService.setAvailableCustomer(customers.getId(), false);
            } else if (accounts.getRole().getId() == Accounts.EMPLOYEE && employees != null) {
                employeeService.setAvailableEmployee(employees.getId(), false);
            }
        }
        response.sendRedirect("AccountServlet?action=list");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accountService.checkAccount(email, username)) {
            Accounts accounts = new Accounts(email, username, password);
            accountService.insertAccount(accounts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/create-done.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", "fail");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop/signin.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void accountLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accountService.checkLogin(username, password)) {
            HttpSession session = request.getSession();
            Accounts accounts = accountService.selectAllAccount().get(username);
            session.setAttribute("accounts", accounts);
            session.setAttribute("username", accounts.getUsername());
            session.setAttribute("id_account", accounts.getId());
            session.setAttribute("role", accounts.getRole().getId());
            if (accounts.getRole().getId() == Roles.CUSTOMER) {
                Cookie user = new Cookie("username", username);
                Cookie pass = new Cookie("password", password);
                if (request.getParameter("rememberMe") != null) {
                    user.setMaxAge(60 * 60 * 24);
                    pass.setMaxAge(60 * 60 * 24);
                } else {
                    user.setMaxAge(0);
                    pass.setMaxAge(0);
                }
                response.addCookie(user);
                response.addCookie(pass);
                response.sendRedirect("/ShopServlet");
            } else {
                response.sendRedirect("/AdminServlet?action=index");
            }
        } else {
            request.setAttribute("mess", "fail");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void accountResetPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Accounts accounts = accountService.selectAllAccountByEmail().get(email);
        if (accounts != null) {
            accountService.forgetPass(email);
            Email.sendEmail(email, "Thehome - Reset Password", "Hi " + accounts.getUsername() + " ! <br> Password mới của bạn là: 123 <br> Good day !!!");
            request.setAttribute("done", "done");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop/forget-password.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mess", "fail");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop/forget-password.jsp");
            dispatcher.forward(request, response);
        }
    }

}