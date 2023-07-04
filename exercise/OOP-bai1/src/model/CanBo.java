package model;

public abstract class CanBo implements Comparable<CanBo> {
    protected static int countEmployee = 0;

    protected int id;
    protected String name;
    protected int yearOfBirth;
    protected boolean gender;
    protected String address;

    public CanBo() {
        this.id = countEmployee++;
    }

    public CanBo(String name, int yearOfBirth, boolean gender, String address) {
        this.id = countEmployee++;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract String toFile();
    @Override
    public int compareTo(CanBo o) {
        return name.equals(o.getName()) ? 1 : -1;
    }
}
