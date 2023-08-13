package model;

public class ReceiptForm {
    private int id;
    private String name;

    public ReceiptForm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ReceiptForm() {
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
}
