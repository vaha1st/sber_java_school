package contest;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipliedMtx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read configuration line
        int[] conf = Arrays.stream(scanner.nextLine().strip().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        // Generate matrices from standard input
        long[][] firstMtx = generateMtxFromStdIn(scanner, conf[0]);
        long[][] secondMtx = generateMtxFromStdIn(scanner, conf[1]);


        // Multiply matrices
        long[][] resultingMtx = multiplyMtxs(firstMtx, secondMtx);

        // Print result
        printMtx(resultingMtx);
    }

    private static long[][] multiplyMtxs(long[][] firstMtx, long[][] secondMtx) {
        // Check if not multipliable
        if (firstMtx[0].length != secondMtx.length) {
            throw new InputMismatchException();
        }
        long[][] resultingMtx = new long[firstMtx.length][secondMtx[0].length];
        for (int i = 0; i < firstMtx.length; i++) {
            for (int j = 0; j < secondMtx[0].length; j++) {
                for (int k = 0; k < secondMtx.length; k++) {
                    resultingMtx[i][j] += firstMtx[i][k] * secondMtx[k][j];
                }
            }
        }
        return resultingMtx;
    }

    private static long[][] generateMtxFromStdIn(Scanner scanner, int arrayLength) {
        long[][] mtx = new long[arrayLength][];
        for (int i = 0; i < arrayLength; i++) {
            mtx[i] = Arrays.stream(scanner.nextLine().strip().split(" ")).
                    mapToLong(Long::parseLong).toArray();
        }
        return mtx;
    }

    private static void printMtx(long[][] mtx) {
        for (long[] longs : mtx) {
            for (int j = 0; j < mtx[0].length; j++) {
                if (j < mtx[0].length - 1) {
                    System.out.print(longs[j] + " ");
                } else {
                    System.out.print(longs[j]);
                }
            }
            System.out.println();
        }
    }
}
