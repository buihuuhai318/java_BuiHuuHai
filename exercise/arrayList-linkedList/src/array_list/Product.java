package array_list;

public class Product {
    private static int countProduc;

    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String name, int price) {
        this.id = countProduc++;
        this.name = name;
        this.price = price;
    }

    public static int getCountProduc() {
        return countProduc;
    }

    public static void setCountProduc(int countProduc) {
        Product.countProduc = countProduc;
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

    @Override
    public String toString() {
        return String.format(
                "|  %s: %2d  |  %s: %17s  |  %s: %5s  |",
                "ID", id, "Tên", name, "Giá", price);
    }
}
