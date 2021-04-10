package course.exceptions.bestPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 13
 * Бросайте из метода только релевантные исключения.
 *
 */
public class Practice13 {
    static int releaseYear;

    public static void main(String[] args) {

    }

    // В данном методе выбрасывается IOException - исключение ввода/вывода,
    // хотя здесь нет соответствующих операций, связанных с файлами,
    // сетевыми соединениями и прочими потоками данных.
    private static void setYear(int year) throws IOException {
        if(year <= 0) {
            throw new IOException();
        }
        releaseYear = year;
    }


    // Здесь скрывается истинная причина ошибки и
    // выбрасывается неподходящее и не имеющее смысла исключение.
    private static void readFile(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            throw new NullPointerException();
        }
    }
}
