package course.homeworks.hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

// Задача 2 из pdf/Занятие_3_Типы_данных,_управляющие_конструкции.pdf
public class TextFrame {

    private static void put_error(){
        System.err.println("Ошибка");
        System.exit(-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = 0, height = 0;
        String str = "";
        try{
            height = scanner.nextInt();
            scanner.nextLine();
            width = scanner.nextInt();
            scanner.nextLine();
            str = scanner.nextLine();
        } catch (InputMismatchException e) {
            put_error();
        }
        if (width - 2 < str.length() || height < 3)
            put_error();
        for (int i = 0; i < height; i++){
            if (i == 0 || i == height - 1){
                for (int j = 0; j < width - 1; j++){
                    System.out.print("*");
                }
                System.out.println();
            } else if (i == (height - 1) / 2) {
                System.out.print("*");
                int j = 1;
                while (j < (width - 1 - str.length()) / 2){
                    System.out.print(" ");
                    j++;
                }
                System.out.print(str);
                j += str.length();
                while (j < width - 2) {
                    System.out.print(" ");
                    j++;
                }
                System.out.println("*");
            } else {
                System.out.print("*");
                for(int j = 1; j < width - 2; j++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }
}
