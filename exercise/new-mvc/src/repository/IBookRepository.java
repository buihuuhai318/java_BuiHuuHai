package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> listBook();

    void addNew(Book book);

    int searchId(int id);
    Book getBook(int index);

    List<Book> sortByPriceFromCheap();

    List<Book> sortByPriceFromExpensive();
}
