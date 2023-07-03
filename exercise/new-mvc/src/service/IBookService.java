package service;

import model.Book;

import java.util.List;

public interface IBookService {
    void addNew();
    void display();

    void sortByPriceFromCheap();

    void sortByPriceFromExpensive();
}
