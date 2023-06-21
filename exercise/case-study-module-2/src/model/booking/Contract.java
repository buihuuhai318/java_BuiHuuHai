package model.booking;

public class Contract {

    private static int countContract = 0;
    private String id;
    private String bookingCode;

    private int depositForRent;

    private int totalForRent;

    public Contract() {
        this.id = "HD-" + countContract++;
    }

    public Contract(String bookingCode, int depositForRent, int totalForRent) {
        this.id = "HD-" + countContract++;
        this.bookingCode = bookingCode;
        this.depositForRent = depositForRent;
        this.totalForRent = totalForRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
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
                id, bookingCode, depositForRent, totalForRent);
    }
}
