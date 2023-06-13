import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Khai bao doi tuong
        TriangleEdgesCheck check = new TriangleEdgesCheck();

        // Nhap du lieu
        try {
            System.out.print("cạnh thứ 1: ");
            int a = input.nextInt();
            System.out.print("cạnh thứ 2: ");
            int b = input.nextInt();
            System.out.print("cạnh thứ 3: ");
            int c = input.nextInt();

            try {
                check.checkTriangleEdges(a, b, c);
            } catch (TriangleEdgesException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Sai: chỉ được nhập số");
        }

        input.close();
    }
}