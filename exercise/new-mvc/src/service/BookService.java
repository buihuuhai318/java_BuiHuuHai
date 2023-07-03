package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;
import util.CheckInput;

import java.util.List;

public class BookService implements IBookService {
    IBookRepository bookRepository = new BookRepository();


    @Override
    public void addNew() {
        int id = CheckInput.checkId();
        String name = CheckInput.checkName();
        String author = CheckInput.checkAuthor();
        int price = CheckInput.checkPrice();
        Book book = new Book(id, name, author, price);
        System.out.println(book);
        bookRepository.addNew(book);
    }

    @Override
    public void display() {
        List<Book> bookList = bookRepository.listBook();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Override
    public void sortByPriceFromCheap() {
        List<Book> bookList = bookRepository.sortByPriceFromCheap();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Override
    public void sortByPriceFromExpensive() {
        List<Book> bookList = bookRepository.sortByPriceFromExpensive();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
