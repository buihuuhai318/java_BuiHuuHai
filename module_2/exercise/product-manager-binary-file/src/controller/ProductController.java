package controller;

import service.ProductService;

import static view.Main.input;

public class ProductController {

    ProductService productService = new ProductService();
    public void display() {
        do {
            System.out.println("\n-------------------------- Trình Quản Lý Sản Phẩm ----------------------------");
            System.out.println("------------------------------------------------------------------------------");
            productService.display();
            System.out.println("------------------------------------------------------------------------------\n");
            System.out.println("1. Thêm Mới");
            System.out.println("2. Tìm Kiếm Theo ID");
            System.out.println("3. Tìm Kiếm Theo Tên");
            System.out.println("4. Thoát\n");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> productService.add();
                case 2 -> productService.srearchById();
                case 3 -> productService.srearchByName();
                case 4 -> System.exit(0);
            }
        } while (true);
    }
}
