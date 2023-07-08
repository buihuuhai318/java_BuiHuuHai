package s13_14_15_16_17.util;

import s13_14_15_16_17.model.TargetList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAnhWrite {

    static public final String PATH_FILE = "src/s13_14_15_16_17/data/target_list.csv";
    static public final String PATH_FILE_BINARY = "src/s13_14_15_16_17/data/target.dat";
    public void writeFile(String path, List<String> list, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);

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

    public List<String> readFile(String path) {
        List<String> list = new ArrayList<>();

        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public void writeFileBinary(String path, List<TargetList> targetLists) {
        File file = new File(path);
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(targetLists);

            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TargetList> readFileBinary(String path) {
        List<TargetList> targetLists = new ArrayList<>();

        File file = new File(path);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;


        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            targetLists = (List<TargetList>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return targetLists;
    }
}
