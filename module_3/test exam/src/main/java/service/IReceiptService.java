package service;

import model.ReceiptForm;

import java.util.Map;

public interface IReceiptService {
    Map<Integer, ReceiptForm> listReceipt();

    ReceiptForm select(int id);
}
