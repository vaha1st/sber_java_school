package course.homeworks.hw3.hash;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/**
 * Пример сортировки коллекций с использованием метода Collections.sort()
 * Классы объектов, помещаемых в коллекцию, предназначенной для сортировки, должны удовлетворять одному условию:
 * реализовывать интерфейс Comparable.
 * Класс String реализовывает этот интерфейс, а класс Book мы написали сами, поэтому необходимо позаботиться
 * о реализации интерфейса самостоятельно. Без этого метод sort не будет знать, по каким критериям производить
 * сортировку.
 */
public class Main {

    public static void main(String[] args) {
        String b1 = "Сказки";
        String b2 = "Физика";
        String b3 = "Программирование на Java";

        var shelf = new ArrayList<String>();
        shelf.add(b1);
        shelf.add(b2);
        shelf.add(b3);

        System.out.println(shelf);

        Collections.sort(shelf);

        System.out.println(shelf);


        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Fitzgerald", "The great Gatsby", 1999, 2000));
        books.add(new Book("Rand", "Atlas shrugged", 1987, 120));
        books.add(new Book("Orwell", "Animal farm", 2001, 629));
        books.add(new Book("Orwell", "1984", 1979, 1340));

        System.out.println("Before sort ================================");
        System.out.println(books);

        Collections.sort(books);

        System.out.println("\nAfter sort ================================");
        System.out.println(books);

        Book book1 = new Book("Fitzgerald", "The great Gatsby", 1999, 2000);
        Book book2 = new Book("Fitzgerald", "The great Gatsby", 1999, 2000);
        Book book3 = new Book("Fitzgerald", "The great Gatsby", 19992, 20002);
        System.out.println(book1.equals(book2));
        System.out.println(book2.equals(book1));
        System.out.println(book3.equals(book1));

        // Homework
        System.out.println(book1.hashCode());
        System.out.println(new EffectiveHashcode().getHashcode(book1));
        System.out.println(book1.getClass().hashCode());
    }
}