package controller;

import service.IPlayerService;
import service.PlayerService;
import util.NotFourdExeption;

import static view.Main.input;

public class Controller {

    IPlayerService playerService = new PlayerService();

    public void displayMenu() {
        do {
            System.out.println("1. danh sach cau thu \n" +
                    "2. them moi cau thu \n" +
                    "3. da pen\n");
            System.out.print(" - enter your action: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> playerService.display();
                case 2 -> playerService.addNew();
                case 3 -> {
                    try {
                        playerService.takePen();
                    } catch (NotFourdExeption e) {
                    }
                }
                case 4 -> System.exit(0);
            }
        } while (true);

    }
}
