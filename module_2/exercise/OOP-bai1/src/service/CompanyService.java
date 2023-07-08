package service;

import model.CanBo;
import model.CongNhan;
import model.KySu;
import model.NhanVien;
import responsitory.CompanyRepository;
import responsitory.ICompanyRepository;

import java.util.Collections;
import java.util.List;

import static view.Main.input;

public class CompanyService implements ICompanyService {
    ICompanyRepository companyRepository = new CompanyRepository();

    public void display() {
        for (CanBo canBo : companyRepository.display()) {
            System.out.println(canBo);
        }
    }

    public void searchByName() {
        System.out.println("nhap ten nha vien: ");
        String name  = input.nextLine();
        for (CanBo canBo : companyRepository.display()) {
            if (canBo.getName().contains(name)) {
                System.out.println(canBo);
            }
        }
    }

    public void sortByName() {
        List<CanBo> canBoList = companyRepository.display();
        Collections.sort(canBoList);
        for (CanBo canBo : canBoList) {
            System.out.println(canBo);
        }
    }

    public void addNew() {
        System.out.println("nhap ten");
        String name = input.nextLine();
        System.out.println("nhap nam sinh");
        int year = Integer.parseInt(input.nextLine());
        System.out.println("nhap gioi tinh");
        boolean gender = Boolean.parseBoolean(input.nextLine());
        System.out.println("nhap dia chi");
        String address = input.nextLine();

        System.out.println("1. cong nhan \n" +
                "2. ky su \n" +
                "3. nhan vien");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println("nhap cap bac: ");
                int level = Integer.parseInt(input.nextLine());
                companyRepository.addNew(new CongNhan(name, year, gender, address, level));
            }

            case 2 -> {
                System.out.println("nhap chuyen nganh: ");
                String industry = input.nextLine();
                companyRepository.addNew(new KySu(name, year, gender, address, industry));
            }
            case 3 -> {
                System.out.println("nhap cong viec: ");
                String job = input.nextLine();
                companyRepository.addNew(new NhanVien(name, year, gender, address, job));
            }
        }
    }
}
