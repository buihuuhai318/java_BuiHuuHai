package service.class_service;

import model.booking.Booking;
import model.facility.Facility;
import repository.class_repo.BookingRepository;
import repository.class_repo.CustomerRepository;
import repository.class_repo.FacilityRepository;
import service.interface_service.IBookingService;
import utils.CheckValueInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static view.Main.input;

public class BookingService extends Service implements IBookingService {

    CustomerRepository customerRepository = new CustomerRepository();
    FacilityService facilityService = new FacilityService();
    FacilityRepository facilityRepository = new FacilityRepository();
    CheckValueInput checkValueInput = new CheckValueInput();
    BookingRepository bookingRepository = new BookingRepository();


    @Override
    public void display() {
        bookingRepository.display();
    }

    @Override
    public void addNew() {
        try {
            System.out.println();
            customerRepository.display();
            System.out.print("\n - Enter ID of Customer: ");
            String customerId = input.nextLine();
            int indexCustomer = customerRepository.checkID(customerId);
            if (indexCustomer == -1) {
                System.out.println("------ This ID not found !!! ------");
            } else {
                System.out.println();
                customerRepository.formHead();
                System.out.println(customerRepository.getElement(indexCustomer));
                facilityService.display();
                System.out.print("\n - Enter Code of Facility: ");
                String facilityId = input.nextLine();
                int indexFacility = facilityRepository.checkID(facilityId);
                if (indexFacility == -1) {
                    System.out.println("------ This CODE not found !!! ------");
                } else {
                    Facility facility = facilityRepository.getElement(indexFacility);
                    if (facility.getCodeService().matches("^SVVL.*")) {
                        facilityRepository.villaHead();
                    } else if (facility.getCodeService().matches("^SVHO.*")) {
                        facilityRepository.houseHead();
                    } else {
                        facilityRepository.roomHead();
                    }
                    System.out.println(facility);
                    System.out.println("\n---------------- New Booking ------------------\n");
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String date = LocalDate.now().format(myFormatObj);
                    System.out.print(" - from ");
                    String startTime = checkValueInput.checkDate();
                    System.out.print(" - to ");
                    String endTime = checkValueInput.checkDate();
                    Booking booking = new Booking(date, startTime, endTime, customerId, facilityId);
                    bookingRepository.addNew(booking);
                }
            }
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }
}
