package repository;

import model.ReceiptForm;
import model.ReportBoard;

import java.util.Map;

public interface IReceiptFormRepository {
    Map<Integer, ReceiptForm> listReceipt();

    ReceiptForm select(int id);
}
