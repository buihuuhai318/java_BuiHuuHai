package repository;

import model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {
    static List<Word> words = new ArrayList<>();
    static {
        words.add(new Word("hello", "həˈlō"));
        words.add(new Word("good", "ɡo͝od"));
    }

    public int searchId(String name) {
        for (int i = 0; i < words.size(); i++) {
            if (name.equals(words.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public Word getWord(int index) {
        return words.get(index);
    }
}
