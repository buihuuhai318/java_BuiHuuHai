package model;

public class NhanVien extends CanBo {
    private String job;

    public NhanVien() {
        super();
    }

    public NhanVien(String name, int yearOfBirth, boolean gender, String address, String job) {
        super(name, yearOfBirth, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "job='" + job + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public String toFile() {
        return id + "," + name + "," + yearOfBirth + "," + gender + "," + address + "," + job;
    }
}
