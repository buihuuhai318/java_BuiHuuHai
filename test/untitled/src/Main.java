public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,3};
        System.out.println(solution(a));
    }
    static boolean solution(int[] a) {
        int sumleft = 0;
        int sumRight = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j < i) {
                    sumleft += a[j];
                }
                if (j > i) {
                    sumRight += a[j];
                }
            }
            if (sumRight == sumleft) {
                return true;
            } else {
                sumRight = 0;
                sumleft = 0;
            }
        }
        return false;
    }
}

