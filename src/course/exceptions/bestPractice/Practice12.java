package course.exceptions.bestPractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 12
 * Всегда убирайте за собой после обработки исключений.
 *
 * Если используете ресурсы, такие как файлы, соединения с
 * базами данных, сетевые соединения, убедитесь, что
 * освобождаете их корректно. Даже если API для работы с
 * этими ресурсами генерирует непроверяемые исключения,
 * все равно нужно их обрабатывать в блоках try-finally.
 * Внутри блока try запрашивайте доступ к ресурсу, а внутри
 * блока finally освобождайте ресурс. В этом случае, если при
 * доступе к ресурсу возникнет исключение, он будет
 * правильно закрыт (освобождён).
 */
public class Practice12 {
    public static void main(String[] args) {
        FileReader fr = null;

        try {
            fr = new FileReader("test.txt");

        } catch (FileNotFoundException e) {
            // ... код для обработки исключения ...
        }
        finally {
            try {
                fr.close();
            } catch (IOException e) {
                // ... код для обработки исключения ...
            }
        }
    }
}
