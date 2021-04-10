package course.exceptions.bestPractice;

/**
 * Best practice 8
 * Всегда перехватывайте только те исключения,
 * которые сможете обработать.
 *
 * Перехватывайте исключения только для обработки
 * или если нужно добавить в исключение дополнительную
 * информацию.
 * Если можно не перехватывать исключение, не делайте
 * этого только для того, чтобы бросить его еще раз.
 */
public class Practice8 {
    public static void main(String[] args) throws NoSuchMethodException {
        try {
            test();
        } catch (NoSuchMethodException e) {
            throw e;    // Старайтесь так не делать.
        }
    }

    private static void test() throws NoSuchMethodException {
        throw new NoSuchMethodException("Method test() not implemented yet.");
    }
}
