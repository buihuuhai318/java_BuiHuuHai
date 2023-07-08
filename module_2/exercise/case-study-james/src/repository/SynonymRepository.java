package repository;

import model.Synonym;
import model.TypeOfWord;

import java.util.ArrayList;
import java.util.List;

public class SynonymRepository {
    static List<Synonym> synonymList = new ArrayList<>();
    static {
        synonymList.add(new Synonym(0, "hi"));
        synonymList.add(new Synonym(0, "greeting"));
        synonymList.add(new Synonym(0, "what'sup"));
        synonymList.add(new Synonym(1, "well"));
        synonymList.add(new Synonym(1, "nice"));
        synonymList.add(new Synonym(1, "great"));
    }
    public List<Synonym> getSynonymList(int wordIndex) {
        List<Synonym> synum = new ArrayList<>();
        for (int i = 0; i < synonymList.size(); i++) {
            if (synonymList.get(i).getWordId() == wordIndex) {
                synum.add(synonymList.get(i));
            }
        }
        return synum;
    }
}
