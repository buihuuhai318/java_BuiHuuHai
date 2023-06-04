public class Main {
    public static void main(String[] args) {
        int[] arrA = {1,2,3};
        int[] arrB = {4,5,6,7,8,9};

        int[] arrC = new int[arrA.length + arrB.length];

        for (int i = 0; i < arrC.length; i++) {
            if (i < arrA.length) {
                arrC[i] = arrA[i];
            } else {
                arrC[i] = arrB[i - arrA.length];
            }
        }

        System.out.printf("%-12s", "new array");
        for (int i = 0; i < arrC.length; i++) {
            System.out.print(arrC[i] + "\t");
        }
    }
}