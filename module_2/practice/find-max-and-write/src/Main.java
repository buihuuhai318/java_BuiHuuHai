
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> list = readAndWriteFile.readFile("number.txt");
        int maxValue = FindMaxValue.findMax(list);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}