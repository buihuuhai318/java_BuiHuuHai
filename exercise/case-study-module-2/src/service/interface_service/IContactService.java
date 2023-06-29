package service.interface_service;

import model.booking.Contract;

public interface IContactService extends IService {
    void edit();

    Contract changeValueEdit(Contract contract);
}
