package model.booking;

public class Contract {

    private static int countContract = 0;
    private String id;
    private Booking booking;

    private int depositForRent;

    private int totalForRent;

    public Contract() {
        this.id = "HD-" + countContract++;
    }

    public Contract(Booking booking, int depositForRent, int totalForRent) {
        this.id = "HD-" + countContract++;
        this.booking = booking;
        this.depositForRent = depositForRent;
        this.totalForRent = totalForRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getDepositForRent() {
        return depositForRent;
    }

    public void setDepositForRent(int depositForRent) {
        this.depositForRent = depositForRent;
    }

    public int getTotalForRent() {
        return totalForRent;
    }

    public void setTotalForRent(int totalForRent) {
        this.totalForRent = totalForRent;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-6s | %-6s | %7s $ | %5s $ |",
                id, booking.getBookingCode(), depositForRent, totalForRent);
    }
}
