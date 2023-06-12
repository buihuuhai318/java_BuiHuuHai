package class_product;

public class Product {
    private static int countProduct;
    private static boolean arrangement = false;
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name, int price) {
        this.id = countProduct++;
        this.name = name;
        this.price = price;
    }

    public static int getCountProduc() {
        return countProduct;
    }

    public static void setCountProduc(int countProduc) {
        Product.countProduct = countProduc;
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

    public static boolean isArrangement() {
        return arrangement;
    }

    public static void setArrangement(boolean arrangement) {
        Product.arrangement = arrangement;
    }

    @Override
    public String toString() {
        return String.format(
                "|  %s: %2d  |  %s: %17s  |  %s: %5s  |",
                "ID", id, "Tên", name, "Giá", price);
    }
}
