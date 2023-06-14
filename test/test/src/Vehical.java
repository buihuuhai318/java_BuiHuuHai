public abstract class Vehical {
    public String color;
    public int countChoNgoi;

    public Vehical(String color) {
        this.color = color;
    }

    public Vehical() {
    }

    public abstract void howToRide();
    public abstract void whereItRun();

    public int getCountChoNgoi() {
        return countChoNgoi;
    }

    public String getColor() {
        return color;
    }
}
