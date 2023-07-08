package s13_14_15_16_17.model;


import java.io.Serializable;

public class TargetList implements Comparable<TargetList>, Serializable {
    private int id;
    private String name;
    private String date;
    private int money;
    private String description;

    public TargetList() {

    }

    public TargetList(int id, String name, String date, int money, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.money = money;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TargetList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", money=" + money +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public int compareTo(TargetList o) {
        return this.money - o.money != 0 ? this.money - o.money : this.name.compareTo(o.name);
    }
}
