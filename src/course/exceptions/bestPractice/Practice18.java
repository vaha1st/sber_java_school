package course.exceptions.bestPractice;

/**
 * Best practice 18
 * Всегда завершайте прерванный поток.
 *
 * InterruptedException указывает на то, что нужно остановить все,
 * что делали до этого. Обычно поток прерывается при закрытии пула
 * потоков или по таймауту. Вместо игнорирования InterruptedException
 * код должен сделать все, чтобы завершить предыдущую работу.
 */
public class Practice18 {
    public static void main(String[] args) {

//        while (true) {
//            try {
//                Thread.sleep(100000);
//            }
//            catch (InterruptedException e) { }  // Так делать не надо.
//
//            usefulMethod();
//        }

        // Правильный вариант:
        while (true) {
            try {
                Thread.sleep(100000);
            }
            catch (InterruptedException e) {
                break;
            }
        }

        usefulMethod();
    }


    private static void usefulMethod() {
        // что-то полезное
    }
}
