package course.homeworks.hw2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// Задача 1 из pdf/Занятие_3_Типы_данных,_управляющие_конструкции.pdf
public class GuessNum {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = random.nextInt(100);
        int guess = 0;
        System.out.println("Guess the number from 0 to 100");
        while (true) {
            try {
                guess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                continue;
            } finally {
                scanner.nextLine();
            }
            if (guess > 100 || guess < 0) {
                System.out.println("From 0 to 100");
                continue;
            }
            if (guess > num)
                System.out.println("Less");
            else if (guess < num)
                System.out.println("Greater");
            else {
                System.out.println("Got it!");
                System.exit(0);
            }
        }
    }
}
