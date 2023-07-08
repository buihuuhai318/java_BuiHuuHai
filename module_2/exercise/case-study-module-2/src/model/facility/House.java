package model.facility;

public class House extends TypeHouse {

    public House() {
    }

    public House(String codeService, String nameService,
                 double areaToUse, int costToRent, int maxOfPeople, int typeOfRent,
                 int roomStandard, int numOfFloors) {

        super(codeService, nameService, areaToUse, costToRent, maxOfPeople, typeOfRent, roomStandard, numOfFloors);
    }

    @Override
    public String toString() {
        return String.format(
                "| %12s | %10s | %6s | %7s | %8s | %8s | %10s | %8s |",
                codeService, nameService, areaToUse, costToRent, maxOfPeople, Facility.typeOfRentMap.get(typeOfRent), TypeHouse.standardMap.get(roomStandard), numOfFloors);
    }
}
