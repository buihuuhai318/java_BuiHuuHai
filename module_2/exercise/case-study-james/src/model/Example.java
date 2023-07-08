package model;

public class Example {
    static int count = 0;
    private int id;
    private int definitionId;
    private String example;

    public Example(int definitionId, String example) {
        this.id = count++;
        this.definitionId = definitionId;
        this.example = example;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(int definitionId) {
        this.definitionId = definitionId;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "\u001B[31m" + example + "\u001B[0m";
    }
}
