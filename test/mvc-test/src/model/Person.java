package model;

public abstract class Person {
    protected int id;

    protected String name;

    protected boolean gender;

    protected String date;

    public Person() {

    }


    public Person(String name, boolean gender, String date) {
        this.name = name;
        this.gender = gender;
        this.date = date;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
