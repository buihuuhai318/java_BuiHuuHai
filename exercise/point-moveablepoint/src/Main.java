import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(2, 3);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(2, 3, 1, 1);
        System.out.println(moveablePoint);
        System.out.println(Arrays.toString(moveablePoint.getXY()));
        moveablePoint.move();
        System.out.println(moveablePoint);
        System.out.println(Arrays.toString(moveablePoint.getXY()));
    }
}