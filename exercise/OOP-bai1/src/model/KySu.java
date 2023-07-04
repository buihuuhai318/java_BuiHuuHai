package model;

public class KySu extends CanBo {

    private String industry;

    public KySu() {
        super();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public KySu(String name, int yearOfBirth, boolean gender, String address, String industry) {
        super(name, yearOfBirth, gender, address);
        this.industry = industry;
    }

    @Override
    public String toFile() {
        return id + "," + name + "," + yearOfBirth + "," + gender + "," + address + "," + industry;
    }

    @Override
    public String toString() {
        return "KySu{" +
                "industry='" + industry + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
