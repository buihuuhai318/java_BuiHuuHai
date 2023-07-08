package model;

public abstract class Human {
    public int id;
    public String name;
    public String date;
    public boolean gender;

    public Human() {
    }

    public Human(int id, String name, String date, boolean gender) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public Human(String name, String date, boolean gender) {
        this.name = name;
        this.date = date;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        if (gender) {
            return "Nam";
        } else return "Nữ";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", gender=" + gender +
                '}';
    }
}
