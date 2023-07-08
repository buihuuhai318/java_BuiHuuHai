package linked_list.reponsitory;

import model.Product;

public interface IProductReponsitory {
    void addNew(Product product);

    void edit(int id);

    void remove(int id);

    int searchId(int id);
}
