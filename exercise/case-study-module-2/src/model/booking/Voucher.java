package model.booking;

public class Voucher {
    private String code;
    private int sale;
    private String customerId;

    static int countVoucer = 0;

    public Voucher() {
        code = "FU_VOUCHER_" + countVoucer++;
    }

    public Voucher(int sale, String customerId) {
        this.code = "FU_VOUCHER_" + countVoucer++;
        this.sale = sale;
        this.customerId = customerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public static int getCountVoucer() {
        return countVoucer;
    }

    public static void setCountVoucer(int countVoucer) {
        Voucher.countVoucer = countVoucer;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "code='" + code + '\'' +
                ", sale=" + sale +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
