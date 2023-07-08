
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 7, 5, 6, 8, 9};
        soft(array);
        show(array);
        System.out.println();
        System.out.println("index = " + binarySearch(array, 0, array.length - 1, 10));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        }
        if (left > right) {
            return -1;
        }
        if (value > array[middle]) {
            return binarySearch(array, middle + 1, right, value);
        } else {
            return binarySearch(array, left, middle - 1, value);
        }
    }

    public static void soft(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int box = arr[i];
                    arr[i] = arr[j];
                    arr[j] = box;
                }
            }
        }
    }

    public static void show(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
    }
}