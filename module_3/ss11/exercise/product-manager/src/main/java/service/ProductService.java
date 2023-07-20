package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "iphone 11", 1000, "dien thoai apple", "apple"));
        productList.put(2, new Product(2, "iphone 12", 2000, "dien thoai apple", "apple"));
        productList.put(3, new Product(3, "iphone 11 pro max", 1111, "dien thoai apple", "apple"));
        productList.put(4, new Product(4, "iphone 13 pro", 2222, "dien thoai apple", "apple"));
        productList.put(5, new Product(5, "iphone 14 plus", 3333, "dien thoai apple", "apple"));
    }
    @Override
    public List<Product> displayList() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void addNew(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product getProduct(int id) {
        return productList.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
