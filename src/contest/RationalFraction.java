package contest;

import java.util.Arrays;
import java.util.Scanner;

public class RationalFraction {
    public static void main(String[] args) {
        int[] n;
        int devident;
        int devisor;
        int denominator;
        Scanner scanner = new Scanner(System.in);
        n = Arrays.stream(scanner.nextLine().strip().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        devident = n[0] * n[3] + n[2] * n[1];
        devisor = n[1] * n[3];
        denominator = findDenominator(devident, devisor);
        devident /= denominator;
        devisor /= denominator;

        System.out.println(devident + " " + devisor);
    }

    private static int findDenominator(int devident, int devisor){
        if (devisor == 0) {
            return devident;
        }
        else {
            return findDenominator(devisor, devident % devisor);
        }
    }
}
