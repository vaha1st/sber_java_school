package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Best practice 3
 * Ловите исключения конкретных типов, а не типа Exception.
 *
 * В метод, который мы вызываем (в данном случае - test),
 * разработчик может добавить новое проверяемое исключение
 * с намерением, что клиентский код (здесь - main)
 * должен будет его обработать.
 * Однако, если мы отлавливаем только Exception (или Throwable),
 * то никогда не узнаем, что изменилось в коде, который
 * вызываем. Так можно пропустить какую-то важную ошибку.
 */
public class Practice3 {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Что-то пошло не так.");
        }
    }


    private static void test() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }
}
