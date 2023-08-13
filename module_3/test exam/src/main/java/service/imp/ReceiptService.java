package service.imp;

import model.ReceiptForm;
import repository.IReceiptFormRepository;
import repository.imp.ReceiptFormRepository;
import service.IReceiptService;

import java.util.Map;

public class ReceiptService implements IReceiptService {

    private static final IReceiptFormRepository receiptFormRepository = new ReceiptFormRepository();

    @Override
    public Map<Integer, ReceiptForm> listReceipt() {
        return receiptFormRepository.listReceipt();
    }

    @Override
    public ReceiptForm select(int id) {
        return receiptFormRepository.select(id);
    }
}
