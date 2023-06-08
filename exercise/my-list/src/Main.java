public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.addByIndex(1, 4);

        myList.remove(1);
        System.out.println(myList.show());

        myList.add(4);
        System.out.println(myList.show());
        myList.ensureCapacity(7);
        System.out.println(myList.show());
        System.out.println(myList.getSize());
//        myList.clear();
//        System.out.println("clear");
//        System.out.println(myList.show());
//        System.out.println(myList.getSize());

        MyList<Integer> clone = (MyList<Integer>) myList.clone();
        System.out.println("clone");
        System.out.println(clone.show());
        System.out.println(myList.getSize());
    }
}