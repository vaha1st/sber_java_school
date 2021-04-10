package course.exceptions.bestPractice;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Best practice 6
 * Логируйте исключение или бросайте, но не делайте то и другое вместе.
 *
 * Если произойдет ошибка, то в логах будет слишком много лишней информации.
 */
public class Practice6 {
    public static void main(String[] args) throws NoSuchMethodException {
        try {
            test();
        } catch (NoSuchMethodException e) {
            Logger.getGlobal().log(Level.SEVERE, "Some error: ", e);
            throw e;
        }
    }

    private static void test() throws NoSuchMethodException {
        throw new NoSuchMethodException("Method test() not implemented yet.");
    }
}
