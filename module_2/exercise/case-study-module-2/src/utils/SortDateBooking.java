package utils;

import model.booking.Booking;

import java.time.LocalDate;
import java.util.Comparator;

public class SortDateBooking implements Comparator<Booking> {
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
