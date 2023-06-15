package model;

import java.io.Serializable;

public class Product implements Serializable {
    static private int countProduct;
    private String name;
    private int price;
    private String brand;

    private int id;

    public Product() {
    }

    public Product(String name, int price, String brand) {
        this.id = countProduct++;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public static int getCountProduct() {
        return countProduct;
    }

    public static void setCountProduct(int countProduct) {
        Product.countProduct = countProduct;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "|  %s: %2d  |  %s: %17s  |  %s: %5s  | %s: %8s |",
                "ID", id, "Tên", name, "Giá", price, "Thương Hiệu", brand);
    }
}
