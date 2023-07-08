package service;

import model.Product;
import repository.ProductRepository;

import static view.Main.input;

public class ProductService implements IProductService {

    ProductRepository productRepository = new ProductRepository();
    @Override
    public void add() {
        System.out.print(" - nhập tên sản phẩm: ");
        String name = input.nextLine();
        System.out.print(" - nhập giá sản phẩm: ");
        int price = Integer.parseInt(input.nextLine());
        System.out.print(" - nhập thương hiệu sản phẩm: ");
        String brand = input.nextLine();
        Product product = new Product(name, price, brand);
        productRepository.add(product);
    }

    @Override
    public void srearchById() {
        System.out.print(" - nhập ID sản phẩm: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("------------------------------------------------------------------------------");
        productRepository.srearchById(id);
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void srearchByName() {
        System.out.print(" - nhập tên sản phẩm: ");
        String name = input.nextLine().toLowerCase();
        System.out.println("------------------------------------------------------------------------------");
        productRepository.srearchByName(name);
        System.out.println("------------------------------------------------------------------------------");
    }

    @Override
    public void display() {
        productRepository.display();
    }
}
