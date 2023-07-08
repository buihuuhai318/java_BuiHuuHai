package model;

public class Definition {

    static int count = 0;
    private int id;
    private int typeId;
    private String definition;

    public Definition(int typeId, String definition) {
        this.id = count++;
        this.typeId = typeId;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "\u001B[35m" + definition + "\u001B[0m";
    }
}
