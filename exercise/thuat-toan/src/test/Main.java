package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();
        queue.add("Ha Noi ");
        queue.add("Hai Phong ");
        queue.add("Da Nang ");
        queue.add("TPHCM ");
        queue.add("Can Tho ");
        queue.peek();

        System.out.print(queue.poll());
        System.out.print(queue.peek());
        System.out.print(queue.poll());

        queue.poll();
        queue.peek();

        System.out.print(queue.poll());
    }
    public static int recursion (int x, int y) {
        if (x == 1)
            return y;
        else
            return y * recursion(y, x - 1);
    }




}
