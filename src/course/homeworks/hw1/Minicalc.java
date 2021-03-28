package course.homeworks.hw1;

import java.util.Arrays;
import java.util.Scanner;

public class Minicalc {
    public static void main(String[] args) {
        Scanner scanner;
        int[] nums = new int[2];
        String operand = "";
        String tmp;
        try {
            if (args.length == 3) {
                nums[0] = Integer.parseInt(args[0]);
                nums[1] = Integer.parseInt(args[2]);
                operand = args[1];
            } else {
                scanner = new Scanner(System.in);
                tmp = scanner.nextLine().replaceAll("\\s", "");
                nums = Arrays.stream(tmp.split("[+-/*]")).mapToInt(Integer::parseInt).toArray();
                if (nums.length > 2)
                    throw new RuntimeException();
                for(char c : tmp.toCharArray()){
                    if ("+-/*".indexOf(c) >= 0){
                        operand = Character.toString(c);
                        break;
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Invalid input value");
            System.exit(-1);
        }
        switch (operand) {
            case "+":
                System.out.println(nums[0] + nums[1]);
                break;
            case "-":
                System.out.println(nums[0] - nums[1]);
                break;
            case "*":
                System.out.println(nums[0] * nums[1]);
                break;
            case "/":
                try {
                    System.out.println(nums[0] / nums[1]);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    System.exit(-1);
                }
                break;
            default:
                System.out.println("Invalid operand");
                System.exit(-1);
        }
    }
}
