package repository.class_repo;

import model.facility.Facility;
import model.facility.House;
import model.facility.Room;
import model.facility.Villa;
import repository.interface_repo.IFacilityRepository;
import repository.interface_repo.IRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static view.Main.input;

public class FacilityRepository implements IRepository<Facility>, IFacilityRepository {

    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static List<Facility> facilityList = new ArrayList<>();

    static {
        House house = new House("SVHO-0000", "House", 60, 100, 10, 1, 1, 3);
        House house1 = new House("SVHO-0001", "House", 70, 120, 15, 2, 2, 5);
        Villa villa = new Villa("SVVL-0000", "Villa", 100, 300, 20, 3, 3, 3, 100);
        Villa villa1 = new Villa("SVVL-0001", "Villa", 150, 400, 30, 4, 4, 4, 150);
        Room room = new Room("SVRO-0000", "Room", 30, 100, 2, 1, "Breakfast");
        Room room1 = new Room("SVRO-0001", "Room", 40, 100, 2, 2, "Breakfast");
        facilityMap.put(villa, 0);
        facilityMap.put(villa1, 0);
        facilityMap.put(house, 0);
        facilityMap.put(house1, 0);
        facilityMap.put(room, 0);
        facilityMap.put(room1, 0);

        facilityList.add(house);
        facilityList.add(house1);
        facilityList.add(villa1);
        facilityList.add(villa);
        facilityList.add(room1);
        facilityList.add(room);
    }

    @Override
    public void addNew(Facility facility) {
        facilityList.add(facility);
        if (facilityMap.containsKey(facility)) {
            int count = facilityMap.get(facility) + 1;
            facilityMap.put(facility, count);
        } else {
            facilityMap.put(facility, 0);
        }
    }

    @Override
    public void addMaintenance(Facility facility) {
        if (facilityMap.containsKey(facility)) {
            int count = facilityMap.get(facility) + 1;
            facilityMap.put(facility, count);
        } else {
            facilityMap.put(facility, 0);
        }
    }

    @Override
    public void display() {
        int choice;
        String choiceStr;
        do {
            System.out.println("\n - 1. Villa");
            System.out.println(" - 2. House");
            System.out.println(" - 3. Room");
            System.out.println(" - 4. Return\n");
            System.out.print(" - Enter Your Choice: ");
            do {
                choiceStr = input.nextLine();
            } while (!choiceStr.matches("^[1-4]$"));
            choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1 -> {
                    villaHead();
                    for (Facility facility : facilityList) {
                        if (facility instanceof Villa) {
                            System.out.println(facility);
                        }
                    }
                }
                case 2 -> {
                    houseHead();
                    for (Facility facility : facilityList) {
                        if (facility instanceof House) {
                            System.out.println(facility);
                        }
                    }
                }
                case 3 -> {
                    roomHead();
                    for (Facility facility : facilityList) {
                        if (facility instanceof Room) {
                            System.out.println(facility);
                        }
                    }
                }
            }
        } while (choice != 4);
    }

    @Override
    public void showMaintenance() {
        maintenanceHear();
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.printf("| %9s |%8s|%8s|\n", entry.getKey().getCodeService(), entry.getKey().getNameService(), (entry.getValue()) + " ");
        }
    }

    @Override
    public void houseHead() {
        System.out.printf(
                "\n|%12s|%10s|%6s|%7s|%8s|%8s|%10s|%8s|\n",
                "---- Code ----", "--- Name ---", "- Area -", "- Price -", "- People -", "-- Time --", "- Standard -", "- Floors -");
    }

    @Override
    public void villaHead() {
        System.out.printf(
                "\n|%12s|%10s|%6s|%7s|%8s|%8s|%10s|%8s|%6s|\n",
                "---- Code ----", "--- Name ---", "- Area -", "- Price -", "- People -", "-- Time --", "- Standard -", "- Floors -", "- Pool -");
    }

    @Override
    public void roomHead() {
        System.out.printf(
                "\n|%12s|%10s|%6s|%7s|%8s|%8s|%16s|\n",
                "---- Code ----", "--- Name ---", "- Area -", "- Price -", "- People -", "-- Time --", "-- Free Service --");
    }

    @Override
    public void maintenanceHear() {
        System.out.printf(
                "\n|%11s|%8s|%8s|\n",
                "--Service--", "--Name--", "-Amount-");
    }

    @Override
    public Facility getElement(int index) {
        return facilityList.get(index);
    }

    @Override
    public int checkID(String id) {
        for (int i = 0; i < facilityList.size(); i++) {
            if (facilityList.get(i).getCodeService().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
