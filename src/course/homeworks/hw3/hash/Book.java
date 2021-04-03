package course.homeworks.hw3.hash;

import course.homeworks.hw3.hash.EffectiveHashcode;

import java.lang.reflect.Field;

/* Указываем тип, с которым может сравниваться класс,
 * реализующий Comparable.
 * Получается, что при сортировке объекты Book могут
 * сравниваться с другими объектами Book. */
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private int pages;

    Book(String title, String author, int year, int pages) {
        this.year = year;
        this.pages = pages;
        this.author = author;
        this.title = title;
    }

    /* Метод sort передает объект Book в compareTo(), чтобы
     * увидеть, как тот соотносится с экземпляром Book,
     * из которого вызван метод. */
    @Override
    public int compareTo(Book otherBook) {
        /* У string есть метод compareTo, поэтому
         * перекладываем всю работу на него. */
        return this.title.compareTo(otherBook.getTitle());
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year;
        result = 31 * result + pages;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            if (this.author.equals(book.author) &&
                    this.title.equals(book.title) &&
                    this.pages == book.pages &&
                    this.year == book.year) {
                return true;
            }
        }
        return false;
    }
}
