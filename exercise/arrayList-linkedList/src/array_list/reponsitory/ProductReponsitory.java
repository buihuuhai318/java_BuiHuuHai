package array_list.reponsitory;

import model.Product;

import java.util.ArrayList;

import static array_list.view.Main.input;

public class ProductReponsitory implements IProductReponsitory {

    public static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Iphone 13", 1000));
        products.add(new Product("Iphone 14", 2000));
        products.add(new Product("Iphone 14 pro max", 3000));
        products.add(new Product("Iphone 15 pro max", 4000));
    }
    @Override
    public void addNew(Product product) {
        products.add(product);
        System.out.println("\n----- Đã thêm mới " + product.getName() + " thành công !!! -----\n");
        System.out.println("Enter để tiếp tục !!!");
        input.nextLine();
    }

    @Override
    public void edit(int id) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public int searchId(int id) {
        return 0;
    }
}
