public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);

        linkedList.add(4,9);
        linkedList.add(4,14);
        linkedList.printList();
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        System.out.println(linkedList.get(5));
//        linkedList.printList();
    }
}