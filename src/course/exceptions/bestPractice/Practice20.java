package course.exceptions.bestPractice;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Best practice 20
 * Документируйте все типы исключений, возникающие в программе, с помощью JavaDoc.
 *
 * Сделайте своей обычной практикой документирование с помощью JavaDoc всех исключений,
 * которые ваш код может генерировать во время выполнения. Также попробуйте описать
 * возможные действия, которым должен следовать пользователь в случае
 * возникновения этих исключений.
 */
public class Practice20 {
    public static void main(String[] args) {

    }

    /**
     *
     * @throws IOException when file not found.
     */
    private static void test() throws IOException {
        FileReader fr = new FileReader("file.txt");
    }

    /**
     *
     * @throws SQLException when ...  If occurs, make sure DBMS is available.
     */
    private static void cleanUp() throws SQLException {
        Connection connection = null;
        // ... код для установки соединения с БД ...

        Statement stmt = connection.createStatement();
        stmt.execute("select * from users");
        connection.close();
    }
}
