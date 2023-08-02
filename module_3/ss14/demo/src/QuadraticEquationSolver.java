public class QuadraticEquationSolver {

    double a;
    double b;
    double c;
    double delta = b * b - 4 * a * c;
    double root1;
    double root2;

    public QuadraticEquationSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (delta < 0) {
            System.out.println("No real roots.");
        } else if (delta == 0) {
            this.root1 = -b / (2 * a);
            this.root2 = root1;
            System.out.println("One real root: " + root1);
        } else {
            root1 = (-b + Math.sqrt(delta)) / (2 * a);
            root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two real roots: " + root1 + " and " + root2);
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getRoot1() {
        return root1;
    }

    public void setRoot1(double root1) {
        this.root1 = root1;
    }

    public double getRoot2() {
        return root2;
    }

    public void setRoot2(double root2) {
        this.root2 = root2;
    }
}
