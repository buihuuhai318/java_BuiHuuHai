public class Rectangle {
    double height, width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.height + this.width) * 2;
    }

    public String display() {
        return "Rectangle {" + "width = " + width + ", height = " + height + "}";
    }
}
