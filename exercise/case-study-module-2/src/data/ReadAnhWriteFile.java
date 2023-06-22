package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAnhWriteFile {

    public final String EMPLOYEE_FILE = "src/data/file/employee.csv";
    public final String CUSTOMER_FILE = "src/data/file/customer.csv";

    public List<String> readFile(String pathFile) {
        List<String> stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
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

    public void writeFile(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(line);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : list) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
