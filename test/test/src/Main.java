import java.util.ArrayList;

public class Main {
    static int num;

    public static void main(String[] args) {
        Vehical[] vehicals = new Vehical[3];
        vehicals[0] = new Plane();
        vehicals[1] = new Train();
        vehicals[2] = new Car();
        Vehical vehical = new Vehical();
        for (Vehical vehical : vehicals) {
//            ((Service) vehicals[i]).buyTicket();
            if (vehical instanceof Service) {
                ((Service) vehical).buyTicket();
            } else {
                vehical.howToRide();
            }
        }

//        for (int i = 0; i < vehicals.length; i++) {
////            ((Service) vehicals[i]).buyTicket();
//            if (vehicals[i] instanceof Service) {
//                ((Service) vehicals[i]).buyTicket();
//            } else {
//                vehicals[i].howToRide();
//            }
//        }
    }
    static public void alo(int a) {
        System.out.println("alo");
        int n;
//        System.out.println(a);
//        System.out.println(n);
        System.out.println(num);
        return;

    }

}