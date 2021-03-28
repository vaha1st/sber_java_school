package contest;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        double x;
        double profit;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        x = scanner.nextDouble();

        if (x <= 1000) {
            profit = 0;
        } else if (x > 1000 && x <= Math.pow(10, 6)) {
            profit = Math.sqrt((x - 1) / 2);
        } else
            profit = (0.2 + 1 / x) * x;
        System.out.println(df.format(new BigDecimal(profit)));
    }
}
