package service;

import repository.*;

public class WordService {

    WordRepository wordRepository = new WordRepository();
    TypeRepository typeRepository = new TypeRepository();
    DefinitionRepository definitionRepository = new DefinitionRepository();
    ExampleRepository exampleRepository = new ExampleRepository();
    SynonymRepository synonymRepository = new SynonymRepository();

    public void showWord(String inputStr) {
        String word = getWord(inputStr);
        int i = wordRepository.searchId(word);
        if (i != -1) {
            System.out.println("--------------------------------------------------");
            System.out.println(wordRepository.getWord(i));

            for (int j = 0; j < typeRepository.getType(i).size(); j++) {
                System.out.println(typeRepository.getType(wordRepository.searchId(word)).get(j));
                int idType = typeRepository.getType(wordRepository.searchId(word)).get(j).getId();

                for (int k = 0; k < definitionRepository.getDefinition(idType).size(); k++) {
                    System.out.println(definitionRepository.getDefinition(idType).get(k));
                    int idDef = definitionRepository.searchId(idType);

                    for (int l = 0; l < exampleRepository.getExamples(idDef).size(); l++) {
                        System.out.println(exampleRepository.getExamples(idDef).get(l));

                    }
                }
            }
            System.out.println("* Tương Đồng");
            for (int j = 0; j < synonymRepository.getSynonymList(i).size(); j++) {
                System.out.println(synonymRepository.getSynonymList(i).get(j));
            }
        }
    }
    public String getWord(String inputStr) {
        int index = inputStr.lastIndexOf(" ");
        String word = "";
        for (int i = index + 1; i < inputStr.length(); i++) {
            word += inputStr.charAt(i);
        }
        return word;
    }

    public String getDefine(String inputStr) {
        int index = inputStr.lastIndexOf("-");
        String define = "";
        for (int i = index + 1; i < inputStr.length() && inputStr.charAt(i) != ' '; i++) {
            define += inputStr.charAt(i);
        }
        return define;
    }

    public void defineWord(String inputStr) {
        String word = getWord(inputStr);
        int index = wordRepository.searchId(word);
        if (index != -1) {
            String define = getDefine(inputStr);
            if (define.matches("^p$") || define.matches("^-pronoun$")) {
                System.out.println("pronoun");
            } else if (define.matches("^n$") || define.matches("^-noun$")) {
                System.out.println("noun");
            } else if (define.matches("^a$") || define.matches("^-adjective$")) {
                System.out.println("adj");
            } else if (define.matches("^v$") || define.matches("^-verb$")) {
                System.out.println("verb");
            } else if (define.matches("^s$") || define.matches("^-synonymous$")) {
                System.out.println("syn");
            }
        }
    }
}
