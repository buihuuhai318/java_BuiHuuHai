public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4, 9, 6, 7, 8};
        System.out.println("mảng ban đầu");
        show(arr);
        System.out.println();
        insertionSort(arr);
        show(arr);
    }

    public static void insertionSort(int[] arr) {
        System.out.println("---- bắt đầu chạy hàm chèn ----");
        int pos;
        int x;
        System.out.println("------------------------------");
        for (int i = 1; i < arr.length; i++) {
            System.out.println("vòng lặp thứ i (" + i + ")");
            System.out.println("gán x = arr[i(=" + i + ")]" + " = " + arr[i]);
            x = arr[i];
            System.out.println("gán pos = i = " + i);
            pos = i;
            System.out.println();
            if (x > arr[pos - 1]) {
                System.out.println("ta có x = " + x + " > (arr[pos - 1] = " + arr[pos - 1] + ")");
                System.out.println("arr[pos(" + pos + ")]" + " = " + arr[pos]);
                System.out.println("arr[pos-1(" + (pos - 1) + ")]" + " = " + arr[pos - 1]);
                System.out.print("vì arr[pos] > arr[pos - 1] -> ");
            } else {
                System.out.println("- thực hiện thao tác chèn");
                while (pos > 0 && x < arr[pos - 1]) {
                    System.out.println("arr[pos(" + pos + ")]" + " = " + arr[pos]);
                    System.out.println("arr[pos-1(" + (pos - 1) + ")]" + " = " + arr[pos - 1]);
                    System.out.println("vì arr[pos] < arr[pos - 1]");
                    System.out.println("gán cho arr[pos(" + pos + ")]" + " = " + arr[pos] + " <- arr[pos-1(" + (pos - 1) + ")]" + " = " + arr[pos - 1]);
                    arr[pos] = arr[pos - 1];
                    show(arr);
                    System.out.println("giảm pos xuống 1 đơn vị: pos = " + pos + " -> " + (pos - 1));
                    pos--;
                }
            }
            System.out.println("gán arr[pos] = x = " + x);
            arr[pos] = x;
            show(arr);
            System.out.println("------------------------------");
        }
    }

    public static void show(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}