package repository;

import model.Example;

import java.util.ArrayList;
import java.util.List;

public class ExampleRepository {
    static List<Example> exampleList = new ArrayList<>();
    static {
        exampleList.add(new Example(0, "she was getting polite nods and hellos from people"));
        exampleList.add(new Example(1, "I pressed the phone button and helloed"));
        exampleList.add(new Example(2, "a good quality of life"));
        exampleList.add(new Example(3, "a mysterious balance of good and evil"));
        exampleList.add(new Example(4, "my mother could never cook this good"));
    }
    public List<Example> getExamples(int defIndex) {
        List<Example> example = new ArrayList<>();
        for (int i = 0; i < exampleList.size(); i++) {
            if (exampleList.get(i).getDefinitionId() == defIndex) {
                example.add(exampleList.get(i));
            }
        }
        return example;
    }
}
