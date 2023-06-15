package repository;

import common.ReadAndWrite;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    static public List<Product> products = new ArrayList<>();

    static ReadAndWrite readAndWrite = new ReadAndWrite();

    static {
        products.add(new Product("13 pro max", 1000, "iphone"));
        products.add(new Product("12 mini", 500, "iphone"));
        products.add(new Product("ipad", 2000, "iphone"));
        products.add(new Product("macbook", 5000, "iphone"));
        products.add(new Product("galaxy", 1000, "samsung"));
        products.add(new Product("note", 2000, "samsung"));
        products.add(new Product("flip", 3000, "samsung"));
    }

    @Override
    public void display() {
        readAndWrite.writeToFile(products);
        List<Product> listProductFromFile = readAndWrite.readFromFile();
        for (Product product : listProductFromFile) {
            System.out.println(product);
        }
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void srearchById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("\n - không tìm thấy sản phẩm có ID = " + id);
    }

    @Override
    public void srearchByName(String name) {
        int countChar;
        boolean flag = false;
        for (Product product : products) {
            for (int i = 0; i < product.getName().length(); i++) {
                if (product.getName().charAt(i) == name.charAt(0)) {
                    countChar = 1;
                    for (int j = 1; j < name.length(); j++) {
                        if (product.getName().charAt(j + i) == name.charAt(j)) {
                            countChar++;
                        }
                    }
                    if (countChar == name.length()) {
                        System.out.println(product);
                        flag = true;
                        break;
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
        }
    }
}
