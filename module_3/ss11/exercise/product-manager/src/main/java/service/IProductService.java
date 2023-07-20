package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayList();

    void addNew(Product product);

    Product getProduct(int id);

    void edit(int id, Product product);

    void delete(int id);
}
