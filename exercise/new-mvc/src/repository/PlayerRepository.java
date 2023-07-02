package repository;

import model.Player;
import util.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements IPlayerRepository {

//    static List<Player> list = new ArrayList<>();
    ReadAndWrite readAndWrite = new ReadAndWrite();
//    static {
//        list.add(new Player("1", "hai", "1996/08/31", "da nang", "MU"));
//        list.add(new Player("2", "nguyen", "1996/08/31", "da nang", "MU"));
//        list.add(new Player("3", "sang", "1996/08/31", "da nang", "MU"));
//        list.add(new Player("4", "thoi", "1996/08/31", "da nang", "MU"));
//        list.add(new Player("5", "nghia", "1996/08/31", "da nang", "MU"));
//        readAndWrite.write(ReadAndWrite.PATH_FILE, list, false);
//    }
    @Override
    public List<Player> display() {
        List<String> listString = readAndWrite.read(ReadAndWrite.PATH_FILE);
        List<Player> players = new ArrayList<>();
        for (String line : listString) {
            String[] player = line.split(",");
            players.add(new Player(player[0], player[1], player[2], player[3], player[4]));
        }
        return players;
    }

    @Override
    public void addNew(Player player) {
        List<Player> players = display();
        players.add(player);
        readAndWrite.write(ReadAndWrite.PATH_FILE, players, false);
    }
    @Override
    public int searchId(String id) {
        for (int i = 0; i < display().size(); i++) {
            if (display().get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Player getPlayer(int index) {
        return display().get(index);
    }
}
