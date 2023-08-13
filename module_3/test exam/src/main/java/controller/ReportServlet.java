package controller;

import model.ReceiptForm;
import model.ReportBoard;
import repository.IReceiptFormRepository;
import repository.imp.ReceiptFormRepository;
import service.IReceiptService;
import service.IReportService;
import service.imp.ReceiptService;
import service.imp.ReportService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ReportServlet", value = "/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final IReportService reportService = new ReportService();
    private static final IReceiptService receiptService = new ReceiptService();
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
                delete(request, response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "showHard":
                showHard(request, response);
            default:
                showList(request, response);
                break;
        }
    }

    private void showHard(HttpServletRequest request, HttpServletResponse response) {
        List<ReportBoard> list = new ArrayList<>(reportService.listReport().values());
        List<ReportBoard> listThu = new ArrayList<>();
        List<ReportBoard> ListChi = new ArrayList<>();
        String date = String.valueOf(LocalDate.now());
        String[] temp = date.split("-");
        int tempDateNow = Integer.parseInt(temp[2]);
        for (ReportBoard reportBoard : list) {
            if (reportBoard.getReceiptForm().getId() == 1) {
                String[] tempDate = reportBoard.getDate().split("-");
                int now = Integer.parseInt(tempDate[2]);
                if (now <= tempDateNow && now >= tempDateNow - 3) {
                    listThu.add(reportBoard);
                }
            } else {
                String[] tempDate = reportBoard.getDate().split("-");
                int now = Integer.parseInt(tempDate[2]);
                if (now <= tempDateNow && now >= tempDateNow - 3) {
                    listThu.add(reportBoard);
                }
            }
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReceiptForm> formList = new ArrayList<>(receiptService.listReceipt().values());
        request.setAttribute("formList", formList);
        request.getRequestDispatcher("report/create.jsp").forward(request, response);
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ReportBoard reportBoard = reportService.select(id);
        List<ReceiptForm> formList = new ArrayList<>(receiptService.listReceipt().values());
        request.setAttribute("reportBoard", reportBoard);
        request.setAttribute("formList", formList);
        request.getRequestDispatcher("report/edit.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        reportService.delete(id);
        showList(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReportBoard> list = new ArrayList<>(reportService.listReport().values());
        request.setAttribute("list", list);
        request.getRequestDispatcher("report/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                edit(request, response);
                break;
            case "create":
                create(request, response);
            default:
                showList(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportBoard reportBoard = new ReportBoard();
        reportBoard.setName(request.getParameter("name"));
        int receiptId = Integer.parseInt(request.getParameter("receipt"));
        ReceiptForm receiptForm = receiptService.select(receiptId);
        reportBoard.setReceiptForm(receiptForm);
        reportBoard.setDate(request.getParameter("date"));
        reportBoard.setCost(Integer.parseInt(request.getParameter("amount")));
        reportBoard.setNote(request.getParameter("note"));
        reportService.insert(reportBoard);
        showList(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ReportBoard reportBoard = reportService.select(id);
        reportBoard.setName(request.getParameter("name"));
        int receiptId = Integer.parseInt(request.getParameter("receipt"));
        ReceiptForm receiptForm = receiptService.select(receiptId);
        reportBoard.setReceiptForm(receiptForm);
        reportBoard.setDate(request.getParameter("date"));
        reportBoard.setCost(Integer.parseInt(request.getParameter("amount")));
        reportBoard.setNote(request.getParameter("note"));
        reportService.edit(reportBoard);
        showList(request, response);
    }
}