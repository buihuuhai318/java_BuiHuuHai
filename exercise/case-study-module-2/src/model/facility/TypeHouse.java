package model.facility;

import java.util.HashMap;
import java.util.Map;

public abstract class TypeHouse extends Facility {
    protected int roomStandard;
    protected int numOfFloors;

    static Map<Integer, String> standardMap = new HashMap<>();

    static {
        standardMap.put(4, "Standard");
        standardMap.put(3, "Superior");
        standardMap.put(2, "Deluxe");
        standardMap.put(1, "Suite");
    }

    public TypeHouse() {
    }

    public TypeHouse(String codeService, String nameService, double areaToUse, int costToRent, int maxOfPeople, int typeOfRent, int roomStandard, int numOfFloors) {
        super(codeService, nameService, areaToUse, costToRent, maxOfPeople, typeOfRent);
        this.roomStandard = roomStandard;
        this.numOfFloors = numOfFloors;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }
}
