package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 9
 * Не пользуйтесь методом printStackTrace() или похожими.
 *
 * Никогда не оставляйте вызов метода printStackTrace()
 * в своем коде.
 * 1. Метод выводит информацию в поток System.err, который
 * может быть перенаправлен при запуске программы или проигнорирован.
 * 2. Метод не user-friendly, то есть выдает на экран отладочную
 * информацию, плохо воспринимаемую пользователями.
 * 3. В стектрейсе могут содержаться данные, представляющие
 * угрозу безопасности системы.
 */
public class Practice9 {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }
}
