package course.exceptions.bestPractice;

/**
 * Best practice 15
 * Проверяйте вводимые пользователем данные на ранних этапах.
 *
 * Всегда проверяйте пользовательский ввод как можно раньше, до
 * того, как они попадут в основной код для их обработки.
 */
public class Practice15 {
    public static void main(String[] args) {

        // Неправильно:
        // База данных может быть приведена в неконсистентное состояние.
        try {
            validateUser();
            insertUser();

            validateAddress();
            insertAddress();
        } catch (Exception e) {
            // откатить все изменения
        }


        // Правильно:
        // Сначала нужно проверить все полученные данные,
        // а после этого записывать их в БД.
        try {
            validateUser();
            validateAddress();

            insertUser();
            insertAddress();
        } catch (Exception e) {
            // откатить все изменения
        }
    }


    private static void validateUser() throws Exception {
        // Проверка пользовательского ввода: имя пользователя
    }

    private static void validateAddress() throws Exception {
        // Проверка пользовательского ввода: адрес
    }

    private static void insertUser() throws Exception {
        // Добавление информации о пользователе в базу данных
    }

    private static void insertAddress() throws Exception {
        // Добавление информации об адресе в базу данных
    }
}
