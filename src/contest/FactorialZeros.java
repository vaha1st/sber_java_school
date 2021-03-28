package contest;

import java.util.Scanner;

public class FactorialZeros {
    public static void main(String[] args) {
        int n;
        int zeros = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        while (n > 0) {
            n /= 5;
            zeros += n;
        }
        System.out.println(zeros);
    }
}
