package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;

/**
 * Best practice 7
 * Никогда не бросайте исключения из блока finally.
 *
 * Если в блоке finally генерируется исключение, то
 * исключение, брошенное в блоке try, будет потеряно.
 * Обрабатывайте данное исключение (перехватывайте) или
 * логируйте, но не позволяйте ему покинуть блок finally.
 */
public class Practice7 {
    public static void main(String[] args) throws Exception {
        try {
            test();
        }
        /* Неправильно */
        finally {
            cleanUp();
        }
        /* Правильно */
//        finally {
//            try {
//                cleanUp();
//            }
//            catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private static void test() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }

    private static void cleanUp() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }
}
