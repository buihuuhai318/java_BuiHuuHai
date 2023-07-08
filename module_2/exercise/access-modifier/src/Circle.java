public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle() {
    }

    Circle(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    protected double getArea() {
        return radius * radius * Math.PI;
    }
}
