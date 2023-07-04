package model;

public class CongNhan extends CanBo {
    private int level;

    public CongNhan() {
        super();
    }

    @Override
    public String toFile() {
        return id + "," + name + "," + yearOfBirth + "," + gender + "," + address + "," + level;
    }

    public CongNhan(String name, int yearOfBirth, boolean gender, String address, int level) {
        super(name, yearOfBirth, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "level=" + level +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
