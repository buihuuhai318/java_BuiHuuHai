package model;

public class ReportBoard {
    private int id;
    private String name;
    private ReceiptForm receiptForm;
    private String date;
    private int cost;
    private String note;

    public ReportBoard(int id, String name, ReceiptForm receiptForm, String date, int cost, String note) {
        this.id = id;
        this.name = name;
        this.receiptForm = receiptForm;
        this.date = date;
        this.cost = cost;
        this.note = note;
    }

    public ReportBoard(String name, ReceiptForm receiptForm, String date, int cost, String note) {
        this.name = name;
        this.receiptForm = receiptForm;
        this.date = date;
        this.cost = cost;
        this.note = note;
    }

    public ReportBoard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReceiptForm getReceiptForm() {
        return receiptForm;
    }

    public void setReceiptForm(ReceiptForm receiptForm) {
        this.receiptForm = receiptForm;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
