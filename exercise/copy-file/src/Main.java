import java.io.*;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IOException {
        copyFile("source.txt", "target.txt");
    }

    public static void copyFile(String source, String target) throws IOException {

        File fileSource = new File(source);
        File fileTarget = new File(target);
        FileReader fileReader = new FileReader(fileSource);
        FileWriter fileWriter = new FileWriter(fileTarget);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        int fileSize = (int) fileSource.length();

        String length;

        try {
            while ((length = bufferedReader.readLine()) != null) {
                bufferedWriter.write(length);
                bufferedWriter.newLine();
            }
            System.out.println("đã copy file thành công !!!");
            System.out.println("số ký tự = " + fileSize);
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("file không có hoặc lỗi !!!");
        }
    }
}