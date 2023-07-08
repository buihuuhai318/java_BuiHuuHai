package s13_14_15_16_17.service;

import s13_14_15_16_17.model.TargetList;
import s13_14_15_16_17.repository.Repository;

import static s13_14_15_16_17.view.Main.input;

public class Service {

    Repository repository = new Repository();
    public void display() {
        repository.display();
    }
    public void addNew() {
        int index;
        int id;
        do {
            System.out.println("nhap id: ");
            id = Integer.parseInt(input.nextLine());
            index = repository.searchId(id);
        } while (index != -1);
        System.out.print("nhap ten: ");
        String name = input.nextLine();
        System.out.print("nhap ngay: ");
        String date = input.nextLine();
        System.out.print("nhap tien: ");
        int money = Integer.parseInt(input.nextLine());
        System.out.print("nhap mo ta: ");
        String description = input.nextLine();

        TargetList targetList = new TargetList(id, name, date, money, description);
        repository.addNew(targetList);
    }

    public void remove() {
        System.out.print("nhap id muon xoa: ");
        int id = Integer.parseInt(input.nextLine());
        int index = repository.searchId(id);
        if (index == -1) {
            System.out.println("id khong ton tai");
        } else  {
            repository.remove(index);
        }
    }
}
