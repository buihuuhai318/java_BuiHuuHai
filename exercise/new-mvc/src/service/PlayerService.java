package service;

import model.Player;
import repository.IPlayerRepository;
import repository.PlayerRepository;
import util.NotFourdExeption;

import java.util.List;

import static view.Main.input;

public class PlayerService implements IPlayerService {

    IPlayerRepository playerRepository = new PlayerRepository();
    @Override
    public void addNew() {
        System.out.print("nhap id: ");
        String id = input.nextLine();
        System.out.print("nhap ten: ");
        String name = input.nextLine();
        System.out.print("nhap ngay sinh: ");
        String birthday = input.nextLine();
        System.out.print("nhap dia chi: ");
        String address = input.nextLine();
        System.out.print("nhap club: ");
        String club = input.nextLine();
        Player player = new Player(id, name, birthday, address, club);
        playerRepository.addNew(player);
    }

    @Override
    public void display() {
        List<Player> playerList = playerRepository.display();
        for (Player player : playerList) {
            System.out.println(player);
        }
    }

    @Override
    public void takePen() throws NotFourdExeption {
        display();
        List<Player> playerList = playerRepository.display();

        System.out.print("chon cau thu da pen voi id = ");
        String id = input.nextLine();

        int index = playerRepository.searchId(id);
        if (index != -1) {
            System.out.println(playerRepository.getPlayer(index));
            randomPen();
        } else {
            throw new NotFourdExeption();
        }

    }

    public void randomPen() {
        try {
            int pen = (int) (Math.random()*5 + 1);
            System.out.println(pen);
            int choice;
            do {
                System.out.print("nhap goc sut cua ban 1-6: ");
                choice = Integer.parseInt(input.nextLine());
            } while (choice > 6 || choice < 1);
            if (pen == choice) {
                System.out.println("khong vao");
            } else {
                System.out.println("vaoooooo");
            }
        } catch (Exception e) {
            System.out.println("nhap sai roi");
            randomPen();
        }
    }
}
