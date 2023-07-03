package repository;

import model.Book;
import util.ReadAndWrite;
import util.SortByPriceFromCheap;
import util.SortByPriceFromExpensive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookRepository implements IBookRepository {

//    static List<Book> bookList = new ArrayList<>();
//    static {
//        bookList.add(new Book(1, "Nghi Giau", "Huu Hai", 1000));
//        bookList.add(new Book(2, "Lam Giau", "Huu Hai", 1000));
//        bookList.add(new Book(3, "Code Gym", "Huu Hai", 1000));
//        bookList.add(new Book(4, "Tinder Hay", "Huu Hai", 1000));
//        bookList.add(new Book(5, "Hello Facebook", "Huu Hai", 1000));
//        ReadAndWrite.write(ReadAndWrite.pathFile, bookList);
//    }

    @Override
    public List<Book> listBook() {
        List<String> bookList = ReadAndWrite.read(ReadAndWrite.pathFile);
        List<Book> newBookList = new ArrayList<>();
        for (String line : bookList) {
            String[] book = line.split(",");
            newBookList.add(new Book(Integer.parseInt(book[0]), book[1], book[2], Integer.parseInt(book[3])));
        }
        return newBookList;
    }

    @Override
    public void addNew(Book book) {
        List<Book> newBookList = listBook();
        newBookList.add(book);
        ReadAndWrite.write(ReadAndWrite.pathFile, newBookList);
    }

    @Override
    public int searchId(int id) {
        List<Book> newBookList = listBook();
        for (int i = 0; i < newBookList.size(); i++) {
            if (newBookList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Book getBook(int index) {
        List<Book> newBookList = listBook();
        return newBookList.get(index);
    }

    @Override
    public List<Book> sortByPriceFromCheap() {
        SortByPriceFromCheap sortCheap = new SortByPriceFromCheap();

        List<Book> newBookList = listBook();

        Collections.sort(newBookList, sortCheap);
        newBookList.sort(sortCheap);
        return newBookList;
    }

    @Override
    public List<Book> sortByPriceFromExpensive() {
        SortByPriceFromExpensive sortExpensive = new SortByPriceFromExpensive();
        List<Book> newBookList = listBook();
        newBookList.sort(sortExpensive);
        return newBookList;
    }
}
