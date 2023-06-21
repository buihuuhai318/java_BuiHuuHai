package model.facility;

import java.util.Objects;

public class Villa extends TypeHouse {

    private double poolArea;

    public Villa() {

    }

    public Villa(String codeService, String nameService, double areaToUse, int costToRent, int maxOfPeople, int typeOfRent, int roomStandard, int numOfFloors, double poolArea) {
        super(codeService, nameService, areaToUse, costToRent, maxOfPeople, typeOfRent, roomStandard, numOfFloors);
        this.poolArea = poolArea;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return String.format(
                "| %12s | %10s | %6s | %7s | %8s | %8s | %10s | %8s | %6s |",
                codeService, nameService, areaToUse, costToRent, maxOfPeople, Facility.typeOfRentMap.get(typeOfRent), TypeHouse.standardMap.get(roomStandard), numOfFloors, poolArea);
    }
}
