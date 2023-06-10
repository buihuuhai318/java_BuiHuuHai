import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("thien", 16);
        hashMap.put("nguyen", 38);
        hashMap.put("sang", 45);
        hashMap.put("hai", 57);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("hai", 27);
        linkedHashMap.put("thien", 26);
        linkedHashMap.put("nguyen", 28);
        linkedHashMap.put("sang", 25);
        System.out.println("\nThe age for " + "hai is " + linkedHashMap.get("hai"));
    }
}