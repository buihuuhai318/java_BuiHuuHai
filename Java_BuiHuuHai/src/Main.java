public class Main {
    public static void main(String[] args) {

        int[] name = {1,2,3,4,5};
        int max = name[0];

        for (int i = 0; i < name.length; i++) {
            if (max < name[i]) {
                max = name[i];
            }
        }
        System.out.println("max la");
        System.out.println(max);
    }
}