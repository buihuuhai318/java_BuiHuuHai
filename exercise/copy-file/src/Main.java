import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        copyFile("source.txt", "target.txt");
    }

    public static void copyFile(String source, String target) throws IOException {

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));

        int fileSize = inputStream.available();

        int length;

        try {
            while ((length = inputStream.read()) != -1) {
                outputStream.write(length);
            }
            System.out.println("đã copy file thành công !!!");
            System.out.println("số ký tự = " + fileSize);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("file không có hoặc lỗi !!!");
        }
    }
}