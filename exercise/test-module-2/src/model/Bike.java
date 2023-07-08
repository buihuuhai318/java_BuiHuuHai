package model;

public class Bike {
    private String id;
    private String name;
    private int year;
    private String volume;
    private String bikeNumber;

    public Bike() {
    }

    public Bike(String id, String name, int year, String volume) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.volume = volume;
        this.bikeNumber = null;
    }

    public Bike(String id, String name, int year, String volume, String bikeNumber) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.volume = volume;
        this.bikeNumber = bikeNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", year= " + year +
                ", volume= " + volume +
                ", bikeNumber= '" + bikeNumber + '\'' +
                '}';
    }

    public String toFile() {
        return id + "," + name+ "," + year + "," + volume + "," + bikeNumber;
    }
}
