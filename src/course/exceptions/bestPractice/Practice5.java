package course.exceptions.bestPractice;

/**
 * Best practice 5
 * Оборачивайте исключения в кастомные так, чтобы не потерять стектрейс.
 */
public class Practice5 {

    // В данном примере уничтожается стектрейс оригинального исключения.
    private void test1() throws MyException {
        int[] array = new int[3];

        try {
            array[4] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new MyException("Error: " + e.getMessage());  // Неправильно
        }
    }


    private void test2() throws MyException {
        int[] array = new int[3];

        try {
            array[4] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new MyException("Error: ", e);                // Правильно
        }
    }
}


class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
