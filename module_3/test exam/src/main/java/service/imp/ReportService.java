package service.imp;

import model.ReportBoard;
import repository.IReportRepository;
import repository.imp.ReportRepository;
import service.IReportService;

import java.util.Map;

public class ReportService implements IReportService {

    private static final IReportRepository reportRepository = new ReportRepository();

    @Override
    public Map<Integer, ReportBoard> listReport() {
        return reportRepository.listReport();
    }

    @Override
    public ReportBoard select(int id) {
        return reportRepository.select(id);
    }

    @Override
    public void edit(ReportBoard reportBoard) {
        reportRepository.edit(reportBoard);
    }

    @Override
    public void insert(ReportBoard reportBoard) {
        reportRepository.insert(reportBoard);
    }

    @Override
    public void delete(int id) {
        reportRepository.delete(id);
    }
}
