package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 2
 * Объявляйте только те типы исключений, которые выбрасываются из метода.
 *
 * Указывая в спецификации метода исключение более общего типа, как в
 * методе test(), мы теряем информацию о том, какая конкретно ошибка
 * может произойти при выполнении данного метода.
 * Если в методе выбрасываются много исключений разных типов, которые нужно
 * обрабатывать одинаково, то можно создать собственный класс исключения,
 * объединяющий их все (неактуально в Java 7 и выше),
 * или провести рефакторинг метода.
 */
public class Practice2 {
    public static void main(String[] args) {
    }

    // Неправильный вариант.
    // В спецификации метода указано исключение
    // общего типа (Exception). Но на самом деле, в методе
    // генерируется исключение конкретного типа - IOException
    private static void test1() throws Exception {
        FileReader fr = new FileReader("file.txt");
    }


    // Правильный вариант.
    // В спецификации метода указано именно то исключение, которое
    // выбрасывается при создании объекта FileReader.
    private static void test2() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }
}
