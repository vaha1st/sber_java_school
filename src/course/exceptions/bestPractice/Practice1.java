package course.exceptions.bestPractice;

import java.io.IOException;

/**
 * Best practice 1
 * Никогда не "проглатывайте" исключения в блоке catch.
 *
 * Игнорируя исключения, мы теряем информацию о том, какая именно
 * ошибка произошла и как на нее реагировать.
 */
public class Practice1 {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            return;
        }
    }

    private static void test() throws IOException {
        // ... Some code ...
        throw new IOException();
    }
}
