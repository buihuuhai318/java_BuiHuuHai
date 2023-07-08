package model;

public class Synonym {
    private int id;
    private int wordId;

    private String synonymWord;

    static int count = 0;

    public Synonym(int wordId, String synonymWord) {
        this.id = count++;
        this.wordId = wordId;
        this.synonymWord = synonymWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getSynonymWord() {
        return synonymWord;
    }

    public void setSynonymWord(String synonymWord) {
        this.synonymWord = synonymWord;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Synonym.count = count;
    }

    @Override
    public String toString() {
        return "\u001B[32m" + synonymWord + "\u001B[0m";
    }
}
