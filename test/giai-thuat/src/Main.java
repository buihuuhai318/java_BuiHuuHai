public class Main {
    public static final int HEIGHT = 9;

    public static void main(String[] args) {
        for (int i = 1; i <= HEIGHT; i++) {
            draw(i);
        }
        for (int i = HEIGHT - 1; i > 0; i--) {
            draw(i);
        }
    }

    public static void draw(int i) {
        for (int j = 0; j <= HEIGHT * 2; j++) {
            if (j == HEIGHT - i || j == HEIGHT + i) {
                System.out.print(i);
            } else System.out.print(" ");
        }
        System.out.println();
    }
}

