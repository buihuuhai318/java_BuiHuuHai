package utils;

import model.CanBo;
import model.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

    public static final String PATH_CN = "src/data/cong-nhan.csv";
    public static final String PATH_KS = "src/data/ky-su.csv";
    public static final String PATH_NV = "src/data/nhan-vien.csv";

    static public void write(String path, List<CanBo> list, boolean append) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (CanBo canBo : list) {
                bufferedWriter.write(canBo.toFile());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public void writeOne(String path, CanBo canBo) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(canBo.toFile());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public List<String> read(String path) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
}
