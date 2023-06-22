package service.class_service;

import model.facility.House;
import model.facility.Room;
import model.facility.Villa;
import repository.class_repo.FacilityRepository;
import service.interface_service.IFacilityService;
import service.interface_service.IService;
import utils.CheckValueInput;

import java.util.Objects;

import static view.Main.input;

public class FacilityService implements IFacilityService, IService {
    private FacilityRepository facilityRepository = new FacilityRepository();
    private CheckValueInput checkValueInput = new CheckValueInput();

    @Override
    public void display() {
        facilityRepository.display();
    }

    public void showMaintenance() {
        facilityRepository.showMaintenance();
    }

    @Override
    public void addNew() {
        try {
            System.out.println("---------- Add New Facility ----------");
            System.out.print("Enter ID ");
            String id = checkValueInput.checkCodeService();
            String name = null;
            if (id.matches("^SVVL-.*")) {
                name = "Villa";
            } else if (id.matches("^SVHO-.*")) {
                name = "House";
            } else if (id.matches("SVRO-.*")) {
                name = "Room";
            }
            System.out.print("Enter Area ");
            double area = checkValueInput.checkArea();
            System.out.print("Enter Price ");
            int price = checkValueInput.checkPrice();
            System.out.print("Enter people ");
            int people = checkValueInput.checkPeople();
            System.out.print("Enter Type Of Rent ");
            int type = checkValueInput.checkTypeOfRent();
            if (Objects.equals(name, "Villa") || Objects.equals(name, "House")) {
                int standard = checkValueInput.checkStandard();
                int floor = checkValueInput.checkFloor();
                if (name.equals("Villa")) {
                    double pool = checkValueInput.checkArea();
                    Villa villa = new Villa(id, name, area, price, people, type, standard, floor, pool);
                    facilityRepository.addNew(villa);
                } else {
                    House house = new House(id, name, area, price, people, type, standard, floor);
                    facilityRepository.addNew(house);
                }
            } else if (Objects.equals(name, "Room")) {
                String freeService = input.nextLine();
                Room room = new Room(id, name, area, price, people, type, freeService);
                facilityRepository.addNew(room);
            }
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }

    }
}
