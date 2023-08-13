package bai12;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2 ,2 ,4 ,3, 2, 3};
        System.out.println(check(arr));
    }

    public static int check(List<Integer> s) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int countCar = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 4) {
                count4++;
            } else if (s.get(i) == 3) {
                count3++;
            } else if (s.get(i) == 2) {
                count2++;
            } else {
                count1++;
            }
        }

        countCar = count4 + count3;

        if (count3 >= count1) {
            if ((count2 * 2) % 4 == 0) {
                countCar += count2 / 2;
            } else {
                countCar += count2 / 2 + 1;
            }
        } else {
            count1 = count1 - count3;
            if ((count2 * 2 + count1) % 4 == 0) {
                countCar += (count1 + count2) / 2;
            } else {
                countCar += (count1 + count2) / 2 + 1;
            }
        }
        return countCar;
    }
}
