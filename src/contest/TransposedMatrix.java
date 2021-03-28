package contest;

import java.util.Arrays;
import java.util.Scanner;

public class TransposedMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int conf[] = Arrays.asList(scanner.nextLine().strip().split(" ")).stream().
                mapToInt(Integer::parseInt).toArray();
        int originalMtx[][] = new int[conf[0]][conf[1]];
        for (int i = 0; i < conf[0]; i++) {
            originalMtx[i] = Arrays.asList(scanner.nextLine().strip().split(" ")).stream().
                    mapToInt(Integer::parseInt).toArray();
        }
        int transposedMtx[][] = transposeMTX(originalMtx);
        for (int i = 0; i < transposedMtx.length; i++) {
            for (int j = 0; j < transposedMtx[0].length; j++) {
                if (j < transposedMtx[0].length - 1) {
                    System.out.print(transposedMtx[i][j] + " ");
                }
                else {
                    System.out.print(transposedMtx[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] transposeMTX(int[][] mtx) {
        int transposedMtx[][] = new int[mtx[0].length][mtx.length];

        for (int i = 0; i < transposedMtx.length; i++) {
            for (int j = 0; j < transposedMtx[0].length; j++) {
                transposedMtx[i][j] = mtx[j][i];
            }
        }
        return transposedMtx;
    }
}
