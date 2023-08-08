package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Test {
    public static String solve(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int index = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result = helper(num % 1000, index, num) + aboveThousand[index] + " " + result;
            }
            num /= 1000;
            index++;
        }
        String finalResult = "";
        for (int i = 0; i < result.length(); i++) {
            if (i == 0) {
                finalResult += result.charAt(i);
                finalResult = finalResult.toUpperCase();
            } else {
                finalResult += result.charAt(i);
            }
        }
        return finalResult.trim();
    }
    private static final String[] belowTen = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] belowTwenty = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] belowHundred = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] aboveThousand = {
            "", "thousand", "million", "billion"
    };

    private static String helper(int num, int index, int input) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return belowTen[num] + " ";
        } else if (num < 20) {
            return belowTwenty[num - 10] + " ";
        } else if (num < 100) {
            return belowHundred[num / 10] + " " + helper(num % 10, index, input);
        } else {
            if (index == 0) {
                if (input >= 1000000) {
                    return belowTen[num / 100] + " hundreds and " + helper(num % 100, index, input);
                } else {
                    return belowTen[num / 100] + " hundred and " + helper(num % 100, index, input);
                }

            } else {
                return belowTen[num / 100] + " hundred " + helper(num % 100, index, input);
            }
        }
    }

    public static void main(String[] args) {
        int num = 1234567;
        String result = solve(num);
        System.out.println(result); // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }

}
