package course.exceptions.bestPractice;

/**
 * Best practice 4
 * Никогда не отлавливайте Throwable.
 *
 * Исключение типа Error - дочерний класс Throwable.
 * Данные исключения (Error и его потомки) представляют ошибки JVM
 * и не обрабатываются виртуальной машиной.
 * В некоторых реализациях JVM такие исключения нельзя добавлять
 * в условие catch.
 */
public class Practice4 {
    public static void main(String[] args) {
        try {
            test();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void test() throws Throwable {
        // ... some code ...
    }
}
