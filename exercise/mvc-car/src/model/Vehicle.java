package model;

public class Vehicle {
    private int id;
    private String nameCar;
    private int capacity;
    private int price;
    private double tax;

    public Vehicle() {
    }

    public Vehicle(int id, String nameCar, int capacity, int price) {
        this.id = id;
        this.nameCar = nameCar;
        this.capacity = capacity;
        this.price = price;
        if (capacity < 100) {
            this.tax = 0.01 * this.price;
        } else if (capacity < 200) {
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

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", nameCar='" + nameCar + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }

    public String toFile() {
        return id + "," + nameCar + "," + capacity + "," + price + "," + tax;
    }
}
