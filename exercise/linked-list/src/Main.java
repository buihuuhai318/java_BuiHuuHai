import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Integer> linkedList = new MyLinkedList<>(5);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.add(4,7);
        linkedList.add(4,6);
        linkedList.addLast(8);
        linkedList.add(3,4);
//        System.out.println(linkedList.remove(7));
        System.out.println(linkedList.removeE(1));
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        for (int i = 0; i < linkedList.getNumNodes(); i++) {
            System.out.println(linkedList.get(i));
        }
//        LinkedList

    }
}