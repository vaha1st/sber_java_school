package contest;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ifelse_formula {
    public static void main(String[] args) {
        double x;
        double y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("#.##");

        if (x >= -1 && x < 1){
            y = Math.sqrt(15 - x * x);
        } else if (x >= 1 && x <= 2) {
            y = 1 / Math.sqrt(x + x * x);
        } else {
            y = x * x * x;
        }
        System.out.println(df.format(y));
    }
}
