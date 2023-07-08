import shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println(rectangle);

        Square square = new Square(5);
        System.out.println(square);
        square.howToColor();

        Square square1 = new Square(5);
        System.out.println(square1);

        Square square2 = new Square(5);
        System.out.println(square2);

        Circle circle = new Circle(5);
        System.out.println(circle);

        System.out.println();

        Shape[] shape = new Shape[5];
        shape[0] = square;
        shape[1] = rectangle;
        shape[2] = square1;
        shape[3] = circle;
        shape[4] = square2;

        System.out.println(Arrays.toString(shape));

        System.out.println();
        for (Shape value : shape) {
            if (value instanceof Colorable) {
                ((Colorable) value).howToColor();
            } else {
                System.out.println(value.getArea());
            }
        }

    }
}