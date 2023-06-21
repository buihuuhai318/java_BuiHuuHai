package service.class_service;

import model.booking.Voucher;
import model.person.Customer;
import repository.class_repo.PromotionRepository;
import service.interface_service.IPromotionService;

import java.util.*;

import static view.Main.input;

public class PromotionService implements IPromotionService {

    PromotionRepository promotionRepository = new PromotionRepository();

    @Override
    public void customerUsed() {
        for (Customer customer : promotionRepository.showInYear()) {
            System.out.println(customer);
        }
    }

    @Override
    public void customerGet() {
        try {
            int count = 0;
            Queue<Customer> customerQueue = new LinkedList<>();
            for (Customer customer : promotionRepository.inMonth()) {
                customerQueue.add(customer);
                System.out.println(customer);
                count++;
            }
            System.out.println("\nThere are  " + count + " customers get Voucher !!!");
            int voucher;
            int voucher10;
            int voucher20;
            int voucher50;

            do {
                System.out.print("\n - Enter amoung of Voucher 10%: ");
                voucher10 = Integer.parseInt(input.nextLine());

                System.out.print("\n - Enter amoung of Voucher 20%: ");
                voucher20 = Integer.parseInt(input.nextLine());

                System.out.print("\n - Enter amoung of Voucher 50%: ");
                voucher50 = Integer.parseInt(input.nextLine());

                voucher = voucher10 + voucher20 + voucher50;

                if (voucher != count) {
                    System.out.println("\n--- Amount Voucher is invalid !!! ---");
                }
            } while (voucher != count);

            List<Voucher> voucherList = new ArrayList<>();

            for (int i = 0; i < voucher10; i++) {
                voucherList.add(new Voucher(50, customerQueue.poll().getId()));
            }
            for (int i = 0; i < voucher20; i++) {
                voucherList.add(new Voucher(20, customerQueue.poll().getId()));
            }
            for (int i = 0; i < voucher50; i++) {
                voucherList.add(new Voucher(10, customerQueue.poll().getId()));
            }

            System.out.println();
            for (Voucher value : voucherList) {
                System.out.println(value);
            }

            promotionRepository.addVoucher(voucherList);
        } catch (Exception e) {
            System.out.println("----------- Input Wrong !!! -----------");
        }
    }

    public void showVoucher() {
        System.out.println();
        for (Voucher voucher : promotionRepository.showVoucher()) {
            System.out.println(voucher);
        }
    }
}
