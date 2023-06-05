public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed;
    private boolean status;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.status = false;
        this.color = "blue";
        this.radius = 5;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if (status) {
            return "Fan {" +
                    "status = fan is on" +
                    ", speed = " + speed +
                    ", radius = " + radius +
                    ", color = '" + color + '\'' +
                    '}';
        } else {
            return "Fan {" +
                    "status = fan is off" +
                    ", radius = " + radius +
                    ", color = '" + color + '\'' +
                    '}';
        }

    }
}
