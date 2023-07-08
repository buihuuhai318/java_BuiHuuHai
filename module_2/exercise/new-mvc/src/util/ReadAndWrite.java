package util;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

    public static final String pathFile = "src/data/book.csv";
    public static void write(String pathFile, List<Book> bookList) {
        try {
            File file = new File(pathFile);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Book book : bookList) {
                bufferedWriter.write(book.toFile());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> read(String pathFile) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(pathFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
    }
}
