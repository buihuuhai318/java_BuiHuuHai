public class Main {
    public static void main(String[] args) {
        int[] arr = {9,1,8,2,7,3,6,4,5};
        show(arr);
        insertionSort(arr);
        show(arr);
    }

    public static void insertionSort(int[] arr) {
        int pointer;
        int holder;
        for (int i = 1; i < arr.length; i++) {
            holder = arr[i];
            pointer = i;
            while (pointer > 0 && holder < arr[pointer - 1]) {
                arr[pointer] = arr[pointer - 1];
                pointer--;
            }
            arr[pointer] = holder;
        }
    }

    public static void show(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}