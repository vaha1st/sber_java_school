package contest;

import java.util.Arrays;
import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        long [] set;

        if (n > 0 && n <= 1000) {
            scanner.nextLine();
            set = Arrays.stream(scanner.nextLine().strip().split(" ")).
                    mapToLong(Long::parseLong).toArray();
            for (long item : set) {
                if (checkIfPrime(item)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean checkIfPrime(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
