import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static final char SPACE = ' ';
    public static Map<String, Integer> wordMap = new TreeMap<>();

    public static void main(String[] args) {
        String str = "Chương trình đếm các lần xuất hiện của từ trong một văn bản" +
                " và hiển thị các từ và sự xuất hiện của chúng " +
                "theo thứ tự trong bảng chữ cái của các từ";
        wordMap = countWords(str);
        for (String key : wordMap.keySet()) {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }

    public static Map<String, Integer> countWords(String str) {
        if (str == null) {
            return wordMap;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != SPACE) {
                stringBuilder.append(str.charAt(i));
            } else {
                addWord(stringBuilder);
                stringBuilder = new StringBuilder();
            }
        }
        addWord(stringBuilder);
        return wordMap;
    }

    public static void addWord(StringBuilder stringBuilder) {
        String word = stringBuilder.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }
}