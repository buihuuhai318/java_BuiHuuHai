package bai11;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5};
        System.out.println(check(arr));
    }

    public static int check(int[] arr) {
        int sum = arr[0] + arr[1];
        int le = arr[2] % sum;
        if (le == 0) {
            int holder = arr[2] / sum;
            return arr[0] * holder;
        } else {
            if (le >= arr[0]) {
                int holder = arr[2] / sum + 1;
                return arr[0] * holder;
            } else {
                int holder = arr[2] / sum;
                return arr[0] * holder + le;
            }
        }
    }
}
