package model;

public class Car implements Comparable<Car> {
    private int id;
    private String name;
    private int price;
    private int volume;
    private double tax;

    public Car() {
    }

    public Car(int id, String name, int price, int volume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.volume = volume;
        if (volume < 100) {
            this.tax = 0.01 * this.price;
        } else if (volume < 200) {
            this.tax = 0.03 * this.price;
        } else {
            this.tax = 0.05 * this.price;
        }
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameCar='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }

    public String toFile() {
        return id + "," + name + "," + price + "," + volume + "," + tax;
    }

    @Override
    public int compareTo(Car o) {
        return this.volume - o.volume;
    }
}
