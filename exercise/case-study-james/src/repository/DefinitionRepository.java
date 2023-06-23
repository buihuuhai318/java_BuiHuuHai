package repository;

import model.Definition;

import java.util.ArrayList;
import java.util.List;

public class DefinitionRepository {
    static List<Definition> list = new ArrayList<>();
    static {
        list.add(new Definition(0,"an utterance of “hello”; a greeting"));
        list.add(new Definition(1,"say or shout “hello”; greet someone"));
        list.add(new Definition(2,"to be desired or approved of"));
        list.add(new Definition(3,"that which is morally right; righteousness"));
        list.add(new Definition(4,"well"));
    }

    public List<Definition> getDefinition(int typeIndex) {
        List<Definition> definitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTypeId() == typeIndex) {
                definitions.add(list.get(i));
            }
        }
        return definitions;
    }

    public int searchId(int indexType) {
        for (int i = 0; i < list.size(); i++) {
            if (indexType == list.get(i).getTypeId()) {
                return i;
            }
        }
        return -1;
    }
}
