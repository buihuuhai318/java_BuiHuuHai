package service;

import model.ReportBoard;

import java.util.Map;

public interface IReportService {
    Map<Integer, ReportBoard> listReport();

    ReportBoard select(int id);

    void edit(ReportBoard reportBoard);

    void insert(ReportBoard reportBoard);

    void delete(int id);
}
