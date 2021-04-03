package course.homeworks.hw3.hash;

import java.util.LinkedList;

public class TestMy {
    boolean b1;
    Boolean b2;
    char    c1;
    Character c2;
    Double      d1;
    double      d2;
    Float       f1;
    float       f2;
    String      str;
    int[]       arr;
    Book        book;

    public TestMy() {
        this.b1 = false;
        this.b2 = true;
        this.c1 = 'a';
        this.c2 = 'b';
        this.d1 = 1.1;
        this.d2 = 2.2;
        this.f1 = 1.1f;
        this.f2 = 1.1f;
        this.str = "hello";
        this.arr = new int[3];
        arr[0] = 123;
        this.book = new Book("asd", "asdas", 1231, 123);
    }
}
