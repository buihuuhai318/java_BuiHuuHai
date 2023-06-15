package repository;

import model.Product;

public interface IProductRepository {
    void add(Product product);

    void srearchById(int id);

    void srearchByName(String name);

    void display();
}
