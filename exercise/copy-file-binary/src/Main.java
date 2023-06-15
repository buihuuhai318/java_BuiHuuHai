import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");

        copyFile(source, target);
    }

    public static void copyFile(File sourcePath, File targetPath) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;


        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(targetPath);

            byte[] buffer = new byte[1024];

            int countByte = inputStream.available();

            int length;
            while ((length = inputStream.read(buffer)) >0) {
                outputStream.write(buffer, 0, length);
            }

            System.out.println("đã copy file thành công !!!");
            System.out.println("số byte = " + countByte);

        } catch (Exception e) {
            System.out.println("file không có hoặc lỗi !!!");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}