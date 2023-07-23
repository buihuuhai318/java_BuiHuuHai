package com.example.team1.controller.accounts;

import com.example.team1.model.accounts.Accounts;
import com.example.team1.service.accounts.AccountService;
import com.example.team1.service.accounts.IAccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountServlet", value = "/AccountServlet")
public class AccountServlet extends HttpServlet {
    private IAccountService accountService = new AccountService();
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
            case "delete":
                showDelete(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "res":
                showResetPassword(request, response);
                break;
            case "logout":
                showLogout(request, response);
                break;
            case "login":
                showLogin(request, response);
                break;
            default:
                showIndex(request, response);
                break;
        }
    }

    private void showIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showResetPassword(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signin.jsp");
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
            case "delete":
                delete(request, response);
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
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Accounts accounts = new Accounts(username, password);
        accountService.insertAccount(accounts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create-done.jsp");
        requestDispatcher.forward(request, response);
    }

    private void accountLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accountService.checkLogin(username, password)) {
            HttpSession session = request.getSession();
            Accounts accounts = accountService.selectAllAccount().get(username);
            session.setAttribute("accounts", accounts);
            session.setAttribute("username", accounts.getUsername());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void accountResetPass(HttpServletRequest request, HttpServletResponse response) {

    }
}