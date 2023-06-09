package model.booking;


import model.facility.Facility;
import model.person.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private static int countBooking = 0;
    private String bookingCode;
    private String dateOfBook;
    private String dateStartRent;
    private String dateStopRent;
    private Customer customer;
    private Facility facility;
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Booking() {
        this.bookingCode = "BO-" + countBooking++;
    }

    public Booking(String dateOfBook, String dateStartRent, String dateStopRent, Customer customer, Facility facility) {
        this.bookingCode = "BO-" + countBooking++;
        this.dateOfBook = dateOfBook;
        this.dateStartRent = dateStartRent;
        this.dateStopRent = dateStopRent;
        this.customer = customer;
        this.facility = facility;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDateOfBook() {
        return dateOfBook;
    }

    public void setDateOfBook(String dateOfBook) {
        this.dateOfBook = dateOfBook;
    }

    public String getDateStartRent() {
        return dateStartRent;
    }

    public void setDateStartRent(String dateStartRent) {
        this.dateStartRent = dateStartRent;
    }

    public String getDateStopRent() {
        return dateStopRent;
    }

    public void setDateStopRent(String dateStopRent) {
        this.dateStopRent = dateStopRent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        LocalDate dateBook = LocalDate.parse(dateOfBook);
        LocalDate dateStart = LocalDate.parse(dateStartRent);
        LocalDate dateStop = LocalDate.parse(dateStopRent);
        return String.format(
                "| %-8s | %7s | %9s | %11s | %10s | %11s |",
                bookingCode, customer.getId(), facility.getCodeService(), dateBook.format(dateFormat), dateStart.format(dateFormat), dateStop.format(dateFormat));
    }

    public static class SortByDate implements Comparator<Booking> {
        @Override
        public int compare(Booking o1, Booking o2) {
            LocalDate dateBooking = LocalDate.parse(o1.getDateStartRent());
            LocalDate dateStar = LocalDate.parse(o2.getDateStartRent());
            if (dateStar.isEqual(dateBooking)) {
                LocalDate stopBooking = LocalDate.parse(o1.getDateStopRent());
                LocalDate stop = LocalDate.parse(o2.getDateStopRent());
                return stop.compareTo(stopBooking);
            }
            return dateStar.isEqual(dateBooking) ? 1 : dateStar.compareTo(dateBooking);
        }
    }

    @Override
    public int compareTo(Booking booking) {
        LocalDate dateBooking = LocalDate.parse(booking.dateStartRent);
        LocalDate dateStar = LocalDate.parse(dateStartRent);
        if (dateStar.isEqual(dateBooking)) {
            LocalDate stopBooking = LocalDate.parse(booking.dateStopRent);
            LocalDate stop = LocalDate.parse(dateStopRent);
            return stop.compareTo(stopBooking);
        }
        return dateStar.isEqual(dateBooking) ? 1 : dateStar.compareTo(dateBooking);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getBookingCode(), booking.getBookingCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingCode());
    }
}
