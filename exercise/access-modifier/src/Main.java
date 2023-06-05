public class Main {
    public static void main(String[] args) {

        Circle test = new Circle();
        Circle test1 = new Circle(5);

        System.out.println(test.getRadius());
        System.out.println(test.getArea());
        System.out.println(test1.getRadius());
        System.out.println(test1.getArea());
    }
}