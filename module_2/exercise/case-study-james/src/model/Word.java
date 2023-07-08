package model;

public class Word {
    static int wordCount = 0;
    private int id;
    private String name;
    private String pronounce;

    public Word() {
        this.id = wordCount++;
    }

    public Word(String name, String pronounce) {
        this.id = wordCount++;
        this.name = name;
        this.pronounce = pronounce;
    }

    public static int getWordCount() {
        return wordCount;
    }

    public static void setWordCount(int wordCount) {
        Word.wordCount = wordCount;
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

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }

    @Override
    public String toString() {
        return "\u001B[34m@" + name + '\t' +
                "\u001B[36m /" + pronounce + "/\u001B[0m";
    }
}
