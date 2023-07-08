package common;

import model.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.*;

public class ReadAndWrite {

    public void writeToFile(List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("product.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(products);
            fileOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> readFromFile() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("product.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            products = (List<Product>) inputStream.readObject();
            fileInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
