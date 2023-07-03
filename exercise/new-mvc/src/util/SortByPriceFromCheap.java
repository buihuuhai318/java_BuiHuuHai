package util;

import model.Book;

import java.util.Comparator;

public class SortByPriceFromCheap implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
