package course.exceptions.bestPractice;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Best practice 16
 * Всегда передавайте всю информацию об ошибке одной записью в лог.
 *
 */
public class Practice16 {
    public static void main(String[] args) {

        Logger logger = Logger.getGlobal();

        // ... какой-то код

        // Неправильно:
        // В многопоточных программах два этих сообщения могут
        // оказаться далеко друг от друга в лог-файле.
        logger.log(Level.INFO, "Updating table A.");
        logger.log(Level.INFO, "Reading table B.");


        // Правильно:
        logger.log(Level.INFO, "Updating table A. Reading table B.");
    }
}
