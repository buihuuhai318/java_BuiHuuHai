package repository;

import model.TypeOfWord;

import java.util.ArrayList;
import java.util.List;

public class TypeRepository {
    static List<TypeOfWord> type = new ArrayList<>();
    static {
        type.add(new TypeOfWord(0, 3));
        type.add(new TypeOfWord(0, 1));
        type.add(new TypeOfWord(1, 2));
        type.add(new TypeOfWord(1, 3));
        type.add(new TypeOfWord(1, 4));
    }

    public List<TypeOfWord> getType(int wordIndex) {
        List<TypeOfWord> typeOfWords = new ArrayList<>();
        for (int i = 0; i < type.size(); i++) {
            if (type.get(i).getWordId() == wordIndex) {
                typeOfWords.add(type.get(i));
            }
        }
        return typeOfWords;
    }

    public void addType() {

    }
}
