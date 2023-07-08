public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public int getNumNodes() {
        return numNodes;
    }

    public MyLinkedList(E data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, E data) {
        Node temp = head;
        Node holder;

        for (int i = 1; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        numNodes++;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public E remove(int index) {
        Node temp = head;
        Node holder;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        if (index == 0) {
            holder = temp;
            temp = temp.next;
            head = temp;

        } else if (index > numNodes) {
            throw new IndexOutOfBoundsException(String.valueOf(false));
        } else {
            holder = temp.next;
            temp.next = temp.next.next;
        }
        numNodes--;
        return holder.data;
    }

    public boolean removeE(E data) {
        Node temp = head;
        if (data == temp.data) {
            temp = temp.next;
            head = temp;
            numNodes--;
            return true;
        }
        for (int i = 0; i < numNodes - 1; i++) {
            if (data == temp.next.data) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }
}
