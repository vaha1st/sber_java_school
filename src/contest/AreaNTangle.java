package contest;

import java.util.Arrays;
import java.util.Scanner;

public class AreaNTangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int [][] xy = new int[n][];
        double result = 0;

        if (n > 2) {
            // Get coordinates
            for (int i = 0; i < n; i++) {
                xy[i] = Arrays.stream(scanner.nextLine().strip().split(" ")).
                        mapToInt(Integer::parseInt).toArray();
            }

            for (int i = 0; i < n - 1; i++) {
                result += xy[i][0]*xy[i + 1][1] - xy[i + 1][0]*xy[i][1];
            }
            result += xy[n - 1][0]*xy[0][1] - xy[n - 1][1]*xy[0][0];
            result = Math.abs(result) / 2;
        }
        System.out.println(result);
    }
}
