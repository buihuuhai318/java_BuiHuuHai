package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static view.Main.input;

public class ReadAndWrite {

    public static final String PATH_FILE_CAR = "src/data/car.csv";

    static public void write(String path, List<String> list, boolean append) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : list) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public List<String> read(String path) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }

    public static int inputInt() {
        int num;
        try {
            num = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("--------Input Wrong--------");
            return inputInt();
        }
        return num;
    }
}
