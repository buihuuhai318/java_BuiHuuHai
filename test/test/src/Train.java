public class Train extends Vehical implements Service {
    @Override
    public void howToRide() {
        System.out.println("ng lai tau");
    }

    @Override
    public void whereItRun() {
        System.out.println("duong ray");
    }

    @Override
    public void buyTicket() {
        System.out.println("mua tai ga tau");
    }

    @Override
    public void kyGui() {
        System.out.println("tu cam theo");
    }
}
