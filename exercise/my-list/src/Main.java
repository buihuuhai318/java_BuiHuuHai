import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
//        System.out.println(myList.show());
//        System.out.println(myList.getSize());
        myList.addByIndex(1, 4);
//        System.out.println(myList.get(0));
//        System.out.println(myList.get(1));
//        System.out.println(myList.remove(0));
//        System.out.println(myList.show());
//        System.out.println(myList.getSize());
        myList.remove(1);
//        System.out.println(myList.show());
//        System.out.println(myList.getSize());
        MyList<Integer> a = myList;
        System.out.println(Arrays.toString(a));


    }
}