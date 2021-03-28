package contest;

import java.util.Arrays;
import java.util.Scanner;

public class HandledMtx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] conf = Arrays.asList(scanner.nextLine().strip().split(" ")).stream().
                mapToInt(Integer::parseInt).toArray();
        int[][] originalMtx = new int[conf[0]][conf[1]];
        for (int i = 0; i < conf[0]; i++) {
            originalMtx[i] = Arrays.asList(scanner.nextLine().strip().split(" ")).stream().
                    mapToInt(Integer::parseInt).toArray();
        }
        int n = scanner.nextInt();

        printMtx(multiplyMtx(originalMtx, n));
    }

    private static void printMtx(int[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[0].length; j++) {
                if (j < mtx[0].length - 1) {
                    System.out.print(mtx[i][j] + " ");
                }
                else {
                    System.out.print(mtx[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] multiplyMtx(int[][] mtx, int factor) {
        for (int i = 0; i < mtx.length; i++) {
            for (int j = 0; j < mtx[0].length; j++) {
                mtx[i][j] *= factor;
            }
        }
        return mtx;
    }
}
