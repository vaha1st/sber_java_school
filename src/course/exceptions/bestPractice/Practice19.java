package course.exceptions.bestPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Best practice 19
 * Используйте метод-шаблон для повторяющихся try-catch.
 *
 * Нет смысла иметь несколько одинаковых try-catch блоков в разных частях кода.
 */
public class Practice19 {
    public static void main(String[] args) {

    }

    private void fileAccess() {
        FileInputStream inp = null;

        try {
            inp = new FileInputStream("");
        } catch (FileNotFoundException e) {
            // ... код для обработки ошибок ...
        } finally {
            FileUtil.close(inp);
        }
    }
}

class FileUtil {

    // Подобный код может использоваться во многих местах программы.
    // Можно выделить его в отдельный метод и использовать повторно.
    public static void close(FileInputStream stream){
        try {
            stream.close();
        } catch(Exception ex) {
            // ... код логирования ошибки ...
        }
    }
}
