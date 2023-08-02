package com.example.team1.controller.admin;

import com.example.team1.model.DTO.HotCustomer;
import com.example.team1.model.DTO.HotItems;
import com.example.team1.service.hot.IStatisticalBoardService;
import com.example.team1.service.hot.StatisticalBoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private static final IStatisticalBoardService boardService = new StatisticalBoardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showIndex(request, response);
                break;
        }
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