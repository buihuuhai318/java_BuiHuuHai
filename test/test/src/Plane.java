public final class Plane extends Vehical implements Service {
    @Override
    public void howToRide() {
        System.out.println("phi cong lai");
    }

    @Override
    public void whereItRun() {
        System.out.println("tren troi");
    }

    @Override
    public void buyTicket() {
        System.out.println("san bay");
    }

    @Override
    public void kyGui() {
        System.out.println("ky gui tai san bay");
    }

}
