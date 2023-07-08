package linked_list.controller;

import linked_list.service.ProductService;

import static linked_list.view.Main.input;

public class ProductController {

    ProductService productService = new ProductService();

    public void displayMenu() {
        do {
            System.out.println("\n------------- Phần Mền Quản Lý Sản Phẩm --------------");
            System.out.println("------------------------------------------------------");
            productService.display();
            System.out.println("------------------------------------------------------");
            System.out.println("\n1. Thêm Mới");
            System.out.println("2. Sữa Thông Tin Sản Phẩm");
            System.out.println("3. Xoá Sản Phẩm");
            System.out.println("4. Tìm Sản Phẩm Theo Tên");
            System.out.println("5. Sắp Xếp Theo Giá Tăng/Giảm Dần");
            System.out.println("6. Thoát");
            System.out.print("\nNhập số để lựa chọn chức năng: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> productService.addNew();
                case 2 -> productService.edit();
                case 3 -> productService.remove();
                case 4 -> productService.searchByName();
                case 5 -> productService.softByPrice();
                case 6 -> System.exit(0);
            }
        } while (true);
    }
}
