package repository.imp;

import model.ReceiptForm;
import model.ReportBoard;
import repository.Base;
import repository.IReceiptFormRepository;
import repository.IReportRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReportRepository implements IReportRepository {

    private static final String SELECT = "select * from report where report_id = ?;";
    private static final String SELECT_ALL = "select * from report;";
    private static final String INSERT = "insert into report (report_name, receipt_id, report_date, report_amount, report_note) value (?, ?, ?, ?, ?);";
    private static final String UPDATE = "update report set report_name = ?, receipt_id = ?, report_date = ?, report_amount = ?, report_note = ? where report_id = ?;";
    private static final String DELETE = "delete from report where report_id = ?;";

    private static IReceiptFormRepository receiptFormRepository = new ReceiptFormRepository();

    @Override
    public Map<Integer, ReportBoard> listReport() {
        Map<Integer, ReportBoard> reportBoardMap = new HashMap<>();

        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("report_id");
                String name = resultSet.getString("report_name");
                int receiptId = resultSet.getInt("receipt_id");
                ReceiptForm receiptForm = receiptFormRepository.select(receiptId);
                String date = resultSet.getString("report_date");
                int amount = resultSet.getInt("report_amount");
                String note = resultSet.getString("report_note");

                ReportBoard reportBoard = new ReportBoard(id, name, receiptForm, date, amount, note);
                reportBoardMap.put(id, reportBoard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reportBoardMap;
    }

    @Override
    public ReportBoard select(int id) {
        ReportBoard reportBoard = new ReportBoard();
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int reportId = resultSet.getInt("report_id");
                String name = resultSet.getString("report_name");
                int receiptId = resultSet.getInt("receipt_id");
                ReceiptForm receiptForm = receiptFormRepository.select(receiptId);
                String date = resultSet.getString("report_date");
                int amount = resultSet.getInt("report_amount");
                String note = resultSet.getString("report_note");

                reportBoard = new ReportBoard(reportId, name, receiptForm, date, amount, note);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reportBoard;
    }

    @Override
    public void edit(ReportBoard reportBoard) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, reportBoard.getName());
            preparedStatement.setInt(2, reportBoard.getReceiptForm().getId());
            preparedStatement.setString(3, reportBoard.getDate());
            preparedStatement.setInt(4, reportBoard.getCost());
            preparedStatement.setString(5, reportBoard.getNote());
            preparedStatement.setInt(6, reportBoard.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(ReportBoard reportBoard) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, reportBoard.getName());
            preparedStatement.setInt(2, reportBoard.getReceiptForm().getId());
            preparedStatement.setString(3, reportBoard.getDate());
            preparedStatement.setInt(4, reportBoard.getCost());
            preparedStatement.setString(5, reportBoard.getNote());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = Base.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
