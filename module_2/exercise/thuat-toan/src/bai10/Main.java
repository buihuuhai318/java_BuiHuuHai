package bai10;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 3};
        int a = 10;
        System.out.println(check(arr, a));
    }

    public static int check(int[] arr, int a) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0 && arr[i - 1] != 0) {
                if (arr[i] - arr[i - 1] > result) {
                    result = arr[i] - arr[i - 1];
                }
            } else if ((i + 1) < arr.length){
                if (arr[i + 1] - arr[i - 1] > result) {
                    result = arr[i + 1] - arr[i - 1];
                }
            }
        }
        return result + a;
    }
}
