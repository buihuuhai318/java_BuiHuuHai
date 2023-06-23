package model;

import java.util.HashMap;
import java.util.Map;

public class TypeOfWord {
    static int typeCount = 0;
    private int id;
    private int wordId;
    private int type;

    static Map<Integer, String> typeMap = new HashMap<>();
    static {
        typeMap.put(1, "động từ");
        typeMap.put(2, "tính từ");
        typeMap.put(3, "danh từ");
        typeMap.put(4, "trạng từ");
        typeMap.put(5, "giới từ");
    }

    public TypeOfWord(int wordId, int type) {
        this.id = typeCount++;
        this.wordId = wordId;
        this.type = type;
    }

    public static int getTypeCount() {
        return typeCount;
    }

    public static void setTypeCount(int typeCount) {
        TypeOfWord.typeCount = typeCount;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static Map<Integer, String> getTypeMap() {
        return typeMap;
    }

    public static void setTypeMap(Map<Integer, String> typeMap) {
        TypeOfWord.typeMap = typeMap;
    }

    @Override
    public String toString() {
        return "\u001B[33m" + "* " + typeMap.get(type) + "\u001B[0m";
    }
}
