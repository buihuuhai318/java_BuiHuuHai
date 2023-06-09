package repository.class_repo;

import model.booking.Contract;
import model.booking.Voucher;
import model.person.Customer;
import repository.interface_repo.IPromotionRepository;

import java.time.LocalDate;
import java.util.*;

import static view.Main.input;

public class PromotionRepository implements IPromotionRepository {

    CustomerRepository customerRepository = new CustomerRepository();
    BookingRepository bookingRepository = new BookingRepository();

    static List<Voucher> voucherList = new ArrayList<>();

    public List<Voucher> showVoucher() {
        return voucherList;
    }

    @Override
    public Set<Customer> showInYear() {
        Set<Customer> customerInYear = new LinkedHashSet<>();
        System.out.println("\n - Enter Year: ");
        String year = input.nextLine();
        customerRepository.formHead();
        String date;
        for (Contract contract : ContactRepository.contractList) {
            String indexCon = contract.getBooking().getBookingCode();
            date = bookingRepository.getElement(bookingRepository.checkID(indexCon)).getDateStartRent();
            String[] array = date.split("-");
            if (Objects.equals(array[0], year)) {
                int index = customerRepository.checkID(bookingRepository.getElement(bookingRepository.checkID(contract.getBooking().getBookingCode())).getCustomer().getId());
                customerInYear.add(customerRepository.getElement(index));
            }
        }
        return customerInYear;
    }

    @Override
    public Set<Customer> inMonth() {
        Set<Customer> customerInMonth = new LinkedHashSet<>();
        String dateNow = String.valueOf(LocalDate.now());
        String[] arrayDateNow = dateNow.split("-");
        String date;
        customerRepository.formHead();
        for (Contract contract : ContactRepository.contractList) {
            String indexCon = contract.getBooking().getBookingCode();
            date = bookingRepository.getElement(bookingRepository.checkID(indexCon)).getDateStartRent();
            String[] array = date.split("-");
            if (Objects.equals(array[0], arrayDateNow[0]) && Objects.equals(array[1], arrayDateNow[1])) {
                int index = customerRepository.checkID(bookingRepository.getElement(bookingRepository.checkID(contract.getBooking().getBookingCode())).getCustomer().getId());
                customerInMonth.add(customerRepository.getElement(index));
            }
        }
        return customerInMonth;
    }

    public void addVoucher(List<Voucher> list) {
        voucherList.addAll(list);
    }
}
