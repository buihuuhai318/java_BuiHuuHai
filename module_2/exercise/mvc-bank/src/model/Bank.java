package model;

public class Bank {
    static public final double interest = 0.035;
    private long stk;
    private String nameStk;
    private double money;

    public Bank() {
    }

    public Bank(long stk, String nameStk, double money) {
        this.stk = stk;
        this.nameStk = nameStk;
        this.money = money;
    }

    public Bank(long stk, String nameStk) {
        this.stk = stk;
        this.nameStk = nameStk;
        this.money = 50;
    }

    public long getStk() {
        return stk;
    }

    public void setStk(long stk) {
        this.stk = stk;
    }

    public String getNameStk() {
        return nameStk;
    }

    public void setNameStk(String nameStk) {
        this.nameStk = nameStk;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void upMoney(double money) {
        this.money += money;
    }

    public void outMoney(double money) {
        if (money < this.money - 1) {
            this.money -= (money + 1);
        } else {
            System.out.println("tk khong du tien");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "stk=" + stk +
                ", nameStk='" + nameStk + '\'' +
                ", money=" + money +
                '}';
    }

    public String toFile() {
        return stk + "," + nameStk + "," + money;
    }
}
