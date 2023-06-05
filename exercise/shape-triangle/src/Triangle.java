public class Triangle extends Shape {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    Triangle() {
    }

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    Triangle(double side1, double side2, double side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double getHeight() {
        double p = getPerimeter() / 2;
        return (Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)) / side1) * 2;
    }

    public double getArea() {
        return side2 * getHeight() / 2;
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color='" + color + '\'' +
                '}' +
                " - Perimeter: " + getPerimeter() +
                " - Area: " + getArea() ;
    }
}
