package model.booking;


import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking> {

    private static int countBooking = 0;
    private String bookingCode;
    private String dateOfBook;
    private String dateStartRent;
    private String dateStopRent;

    private String customerId;
    private String serviceCode;

    public Booking() {
        this.bookingCode = "BO-" + countBooking++;
    }

    public Booking(String dateOfBook, String dateStartRent, String dateStopRent, String customerId, String serviceCode) {
        this.bookingCode = "BO-" + countBooking++;
//        System.out.println(this.bookingCode);
        this.dateOfBook = dateOfBook;
        this.dateStartRent = dateStartRent;
        this.dateStopRent = dateStopRent;
        this.customerId = customerId;
        this.serviceCode = serviceCode;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-8s | %7s | %9s | %11s | %10s | %11s |",
                bookingCode, customerId, serviceCode, dateOfBook, dateStartRent, dateStopRent);
    }

    @Override
    public int compareTo(Booking booking) {
        LocalDate dateBooking = LocalDate.parse(booking.dateStartRent);
        LocalDate date = LocalDate.parse(dateStartRent);
        if (date == dateBooking) {
            LocalDate stopBooking = LocalDate.parse(booking.dateStopRent);
            LocalDate stop = LocalDate.parse(dateStopRent);
            return stop.compareTo(stopBooking);
        }
        return date.isEqual(dateBooking) ? 1 : date.compareTo(dateBooking);
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
