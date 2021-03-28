package contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        Map<Character, Integer> denomination = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        char[] romanArr = scanner.nextLine().strip().toCharArray();
        int tmp = 0;
        int prev = 0;
        int result = 0;


        denomination.put('I', 1);
        denomination.put('V', 5);
        denomination.put('X', 10);
        denomination.put('L', 50);
        denomination.put('C', 100);
        denomination.put('D', 500);
        denomination.put('M', 1000);

        for (int i = 0; i < romanArr.length; i++){
            if (prev != 0 && prev < denomination.get(romanArr[i])) {
                result -= tmp;
                tmp = 0;
            } else if (prev != 0 && prev > denomination.get(romanArr[i])) {
                result += tmp;
                tmp = 0;
            }
            if (tmp == 0 || prev == denomination.get(romanArr[i])) {
                tmp += denomination.get(romanArr[i]);
            }
            prev = denomination.get(romanArr[i]);
        }
        result += tmp;

        System.out.println(result);
    }
}