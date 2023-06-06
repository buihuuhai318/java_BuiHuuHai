import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println(rectangle);
        rectangle.resize(50);
        System.out.println(rectangle);

        Square square = new Square(5);
        System.out.println(square);
        square.resize(20);
        System.out.println(square);

        Circle circle = new Circle(5);
        System.out.println(circle);
        circle.resize(40);
        System.out.println(circle);

        Shape[] shape = new Shape[3];
        shape[0] = rectangle;
        shape[1] = square;
        shape[2] = circle;

        System.out.println(Arrays.toString(shape));
        for (Shape value : shape) {
            value.resize(Math.random() * 99 + 1);
        }
        System.out.println(Arrays.toString(shape));
    }
}