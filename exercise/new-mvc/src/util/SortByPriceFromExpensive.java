package util;

import model.Book;

import java.util.Comparator;

public class SortByPriceFromExpensive implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
