package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 10
 *
 * Используйте блок finally вместо блоков catch, если собираетесь только
 * выполнить освобождение ресурсов, но не обрабатывать исключения.
 *
 */
public class Practice10 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("ExceptionHandlingBestPractices.iml");

        try {
            test(reader);
        }
        finally {
            System.out.println("Cleanup");
            cleanUp(reader);
        }
    }

    private static void test(FileReader reader) throws IOException {
        int b = reader.read();
    }

    private static void cleanUp(FileReader reader) throws IOException {
        reader.close();
    }
}
