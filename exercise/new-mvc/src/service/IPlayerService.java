package service;

import util.NotFourdExeption;

public interface IPlayerService {
    void addNew();

    void display();

    void takePen() throws NotFourdExeption;
}
