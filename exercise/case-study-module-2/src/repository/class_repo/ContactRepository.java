package repository.class_repo;

import model.booking.Booking;
import model.booking.Contract;
import repository.interface_repo.IContactRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository implements IContactRepository {

    static List<Contract> contractList = new ArrayList<>();

    static {
        contractList.add(new Contract("BO-0", 10, 10));
        contractList.add(new Contract("BO-1", 10, 10));
        contractList.add(new Contract("BO-2", 10, 10));
        contractList.add(new Contract("BO-3", 10, 10));
        contractList.add(new Contract("BO-4", 10, 10));
        contractList.add(new Contract("BO-5", 10, 10));
        contractList.add(new Contract("BO-6", 10, 10));
        contractList.add(new Contract("BO-7", 10, 10));
        contractList.add(new Contract("BO-8", 10, 10));
        contractList.add(new Contract("BO-9", 10, 10));
    }

    BookingRepository bookingRepository = new BookingRepository();
    FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void addNew(Contract contract) {
        int index = facilityRepository.checkID(getPeekBooking().getServiceCode());
        facilityRepository.addMaintenance(facilityRepository.getElement(index));
        contractList.add(contract);
        bookingRepository.pollBooking();
    }

    @Override
    public void peekBooking() {
        bookingRepository.bookingHead();
        System.out.println(bookingRepository.getElementQueue());
    }

    @Override
    public Booking getPeekBooking() {
        return bookingRepository.getElementQueue();
    }

    @Override
    public void display() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void head() {
        System.out.printf("\n|%8s|%8s|%11s|%9s|\n",
                "---HD---", "---BO---", "--Deposit--", "--Total--");
    }

    @Override
    public Contract getElement(int index) {
        return contractList.get(index);
    }

    @Override
    public int checkID(String id) {
        for (int i = 0; i < contractList.size(); i++) {
            if (contractList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(Contract contract, int index) {
        contractList.set(index, contract);
    }
}
