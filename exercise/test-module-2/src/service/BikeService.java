package service;

import common.CheckInput;
import common.NotFoundException;
import model.Bike;
import repository.BikeRepository;
import repository.IBikeRepository;

import static view.Main.input;

public class BikeService implements IBikeService {

    IBikeRepository bikeRepository = new BikeRepository();

    @Override
    public void addNew() {
        System.out.println("Nhập id xe (PT-XXX): ");
        String id = CheckInput.checkIdBike();
        System.out.println("Nhập tên xe: ");
        String name = input.nextLine();
        System.out.println("Nhập năm sản xuất xe: ");
        int year = CheckInput.inputInt();
        System.out.println("Nhập dung tích xy lanh xe: ");
        int volume = CheckInput.inputInt();
        String volumeStr = volume + "cc";

        Bike bike = new Bike(id, name, year, volumeStr);
        bikeRepository.addNew(bike);
    }

    @Override
    public void display() {
        for (Bike bike : bikeRepository.toListBike()) {
            System.out.println(bike);
        }
    }

    @Override
    public void addNewBikeNumber() {
        try {
            System.out.println("Nhập id xe muốn đăng ký (PT-XXX): ");
            String id = CheckInput.checkIdBike();
            int index = bikeRepository.searchBike(id);
            if (index == -1) {
                throw new NotFoundException();
            } else {
                if (!bikeRepository.getBike(index).getBikeNumber().equals("null")) {
                    System.out.println("Xe đã được đăng ký");
                    System.out.println(bikeRepository.getBike(index));
                } else {
                    System.out.println(bikeRepository.getBike(index));
                    String bikeNumber = "92D1-";
                    for (int i = 0; i < 5; i++) {
                        int random = (int) (Math.random() * 9);
                        bikeNumber += random;
                    }
                    System.out.println("Biển số xe của bạn là: " + bikeNumber);
                    bikeRepository.addNewBikeNumber(index, bikeNumber);
                }
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Không Tìm Thấy Xe");
        }
    }
}
