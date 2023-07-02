package repository;

import model.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> display();

    void addNew(Player player);

    int searchId(String id);
    Player getPlayer(int index);
}
