package model.facility;


public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String codeService, String nameService, double areaToUse, int costToRent, int maxOfPeople, int typeOfRent, String freeService) {
        super(codeService, nameService, areaToUse, costToRent, maxOfPeople, typeOfRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return String.format(
                "| %12s | %10s | %6s | %7s | %8s | %8s | %16s |",
                codeService, nameService, areaToUse, costToRent, maxOfPeople, Facility.typeOfRentMap.get(typeOfRent), freeService);
    }
}
