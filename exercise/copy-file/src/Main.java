import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");

        copyFile(source, target);
    }

    public static void copyFile(File source, File target) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream countChar = null;


        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(target);
            
            byte[] buffer = new byte[1024];
            
            countChar = new FileInputStream(source);
            int count = countChar.read(buffer);
            
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            
            System.out.println("đã copy file thành công !!!");
            System.out.println("số ký tự trong file là: " + count);
            
        } catch (IOException e) {
            System.out.println("file không có hoặc lỗi !!!");
        } finally {
            if (inputStream != null && countChar != null) {
                inputStream.close();
                countChar.close();
            }
            if (outputStream != null && countChar != null) {
                outputStream.close();
                countChar.close();
            }
        }
    }
}