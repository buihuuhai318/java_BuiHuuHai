package linked_list.service;

import linked_list.reponsitory.ProductReponsitory;
import model.Product;

import java.util.Objects;

import static linked_list.reponsitory.ProductReponsitory.products;
import static linked_list.view.Main.input;

public class ProductService implements IProductService {
    ProductReponsitory productReponsitory = new ProductReponsitory();

    @Override
    public void addNew() {
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(input.nextLine());
        productReponsitory.addNew(new Product(name, price));
    }

    @Override
    public void edit() {
        int index = searchId();
        if (index == -1) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            editDisplay(index);
        }
    }

    public void editDisplay(int id) {
        int choice;
        do {
            System.out.println("\n1. " + products.get(id).getName());
            System.out.println("2. " + products.get(id).getPrice());
            System.out.println("3. Thoát");
            System.out.print("\n - Chọn thông tin bạn muốn sửa: ");
            choice = Integer.parseInt(input.nextLine());
            choiceEdit(choice, id);
        } while (choice != 3);
    }

    public void choiceEdit(int choice, int id) {
        String newName;
        String newPrice;
        switch (choice) {
            case 1 -> {
                System.out.print("- Nhập tên mới: ");
                newName = input.nextLine();
                if (choice() && !Objects.equals(newName, "")) {
                    if (newName != null) {
                        products.get(id).setName(newName);
                        doneDisplay();
                    } else {
                        newName = products.get(id).getName();
                        products.get(id).setName(newName);
                        cancelDisplay();
                    }
                } else {
                    cancelDisplay();
                }
            }
            case 2 -> {
                System.out.print("- Nhập giá mới: ");
                newPrice = input.nextLine();
                if (choice() && !Objects.equals(newPrice, "")) {
                    if (Integer.parseInt(newPrice) > 0) {
                        int newPriceInt = Integer.parseInt(newPrice);
                        products.get(id).setPrice(newPriceInt);
                        doneDisplay();
                    } else {
                        int newPriceInt = products.get(id).getPrice();
                        products.get(id).setPrice(newPriceInt);
                        cancelDisplay();
                    }
                } else {
                    cancelDisplay();
                }
            }
            case 3 -> continueStep();
        }
    }

    @Override
    public void remove() {
        int index = searchId();
        if (index == -1) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            System.out.println("\n" + products.get(index));
            boolean answer = choice();
            if (answer) {
                products.remove(index);
                doneDisplay();
            } else {
                cancelDisplay();
            }
        }
    }

    @Override
    public int searchId() {
        System.out.print("Nhập ID sản phẩm: ");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0; i < ProductReponsitory.products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void searchByName() {
        boolean flag = false;
        int count;
        System.out.print("Nhập tên sản phẩm: ");
        String name = input.nextLine().toLowerCase();
        System.out.println();
        for (Product product : products) {
            for (int j = 0; j < product.getName().length(); j++) {
                if (product.getName().toLowerCase().charAt(j) == name.charAt(0)) {
                    count = 1;
                    for (int k = 1; k < name.length(); k++) {
                        if (product.getName().toLowerCase().charAt(j + k) == name.charAt(k)) {
                            count++;
                        }
                    }
                    if (count == name.length()) {
                        System.out.println(product);
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (!flag) {
            System.out.println("\n - Không tìm thấy sản phẩm...");
            continueStep();
        } else {
            continueStep();
        }
    }

    @Override
    public void softByPrice() {
        for (int i = 0; i < products.size(); i++) {
            if (Product.isArrangement()) {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getPrice() > products.get(j).getPrice()) {
                        Product remove = products.remove(j);
                        products.add(i, remove);
                    }
                }
            } else {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getPrice() < products.get(j).getPrice()) {
                        Product remove = products.remove(j);
                        products.add(i, remove);
                    }
                }
            }
        }
        Product.setArrangement(!Product.isArrangement());
    }

    @Override
    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void continueStep() {
        System.out.print("\nEnter để tiếp tục.....");
        input.nextLine();
    }


    public boolean choice() {
        System.out.print("\n - Nhập YES để tiếp tục: ");
        String answer = input.nextLine().toLowerCase();
        return answer.equals("yes");
    }

    public void doneDisplay() {
        System.out.println("\n-------- Done --------");
        continueStep();
    }

    public void cancelDisplay() {
        System.out.println("\n-------- Cancel --------");
        continueStep();
    }
}
