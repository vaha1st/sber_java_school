package course.exceptions.bestPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * Best practice 14
 * Никогда не используйте исключения для управления потоком выполнения программы.
 *
 * Генерация исключений нагружает процессор, и использование их для
 * управления потоком выполнения может серьезно повлиять на производительность.
 * Также ухудшается читаемость программы.
 */
public class Practice14 {
    public static void main(String[] args) {
//        fillArray();
        getElement();
    }

    // В данном методе генерируется исключение при выходе за границы массива.
    // Вместо этого надо задать явно в условии цикла размер массива или
    // добавить простую проверку текущего индекса (переменной i).
    private static void fillArray() {
        int[] array = new int[5];

        try {
            for (int i = 0; ; i++) {
                array[i] = 1;
            }
        }
        catch (ArrayIndexOutOfBoundsException  e) {
            // ... код для обработки исключения ...
            // или ничего
        }
    }

    // Правильный вариант.
    private static void fillArrayRight() {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        // Или
        for (int i = 0; ; i++) {
            if(i < array.length) {
                array[i] = 1;
            }
        }
    }


    // Попытка извлечения из коллекции несуществующего элемента.
    // То есть str будет равна null.
    private static void getElement() {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "Ten");

        // Неправильно.
        try {
            String str = map.get(5);
            str = str.toUpperCase();
        }
        catch (RuntimeException e) {

        }


        // Правильно.
        String str = map.get(5);

        if(str != null) {
            str = str.toUpperCase();
        }

        // Или:
        if(map.containsKey(5)) {
            String str2 = map.get(5);
            str2 = str2.toUpperCase();
        }
    }
}
