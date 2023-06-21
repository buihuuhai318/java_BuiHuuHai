package model.facility;

import java.util.HashMap;
import java.util.Map;

public abstract class Facility {
    protected String codeService;
    protected String nameService;
    protected double areaToUse;
    protected int costToRent;
    protected int maxOfPeople;
    protected int typeOfRent;

    static Map<Integer, String> typeOfRentMap = new HashMap<>();

    static {
        typeOfRentMap.put(1, "Hour");
        typeOfRentMap.put(2, "Day");
        typeOfRentMap.put(3, "Month");
        typeOfRentMap.put(4, "Year");
    }

    public Facility() {
    }

    public Facility(String codeService, String nameService, double areaToUse, int costToRent, int maxOfPeople, int typeOfRent) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.areaToUse = areaToUse;
        this.costToRent = costToRent;
        this.maxOfPeople = maxOfPeople;
        this.typeOfRent = typeOfRent;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaToUse() {
        return areaToUse;
    }

    public void setAreaToUse(double areaToUse) {
        this.areaToUse = areaToUse;
    }

    public int getCostToRent() {
        return costToRent;
    }

    public void setCostToRent(int costToRent) {
        this.costToRent = costToRent;
    }

    public int getMaxOfPeople() {
        return maxOfPeople;
    }

    public void setMaxOfPeople(int maxOfPeople) {
        this.maxOfPeople = maxOfPeople;
    }

    public int getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(int typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility facility)) return false;

        return getCodeService().equals(facility.getCodeService());
    }

    @Override
    public int hashCode() {
        return getCodeService().hashCode();
    }
}
